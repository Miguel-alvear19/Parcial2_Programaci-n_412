package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.Interfaces.Magico;
import com.parcial.claseAbstracta.Criatura;

/**
 * Clase Mago
 * El mago ataca usando hechizos con su fuerza base como daño.
 * Implementa la interfaz Magico para tener habilidades mágicas especiales.
 * Usa composición con la clase Arma (bastón mágico u otro objeto).
 */
public class Mago extends Criatura implements Magico {

    // Lista o descripción de hechizos que conoce el mago
    private String hechizos;

    // Arma equipada por composición (puede ser null)
    private Arma arma;

    /**
     * Constructor del Mago.
     *
     * @param nombre   Nombre del mago.
     * @param salud    Puntos de salud.
     * @param fuerza   Fuerza mágica base.
     * @param hechizos Hechizos que conoce el mago.
     */
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.arma = null;
    }

    /**
     * Equipa un arma (o bastón) al mago.
     *
     * @param arma El arma a equipar.
     */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " equipó: " + arma.getNombre());
    }

    /**
     * Desequipa el arma actual del mago.
     */
    public void desequiparArma() {
        if (arma != null) {
            System.out.println(nombre + " desequipó: " + arma.getNombre());
            this.arma = null;
        }
    }

    /**
     * El mago ataca lanzando hechizos causando daño igual a su fuerza.
     * Si tiene arma equipada, también la usa para daño adicional.
     *
     * @param objetivo La criatura que recibe el ataque mágico.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza; // El mago usa su fuerza mágica directamente
        System.out.println(nombre + " [Mago] lanza un hechizo (" + hechizos
                + ") sobre " + objetivo.getNombre() + " causando " + dano + " de daño!");
        objetivo.defender(dano);

        // Si tiene arma equipada, aplica daño adicional
        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    /**
     * El mago se defiende con un escudo mágico que absorbe parte del daño.
     * Su escudo reduce el daño en 3 puntos.
     *
     * @param dano Daño recibido.
     */
    @Override
    public void defender(int dano) {
        int escudoMagico = 3; // El escudo mágico reduce el daño
        int danoReal = Math.max(0, dano - escudoMagico);
        salud -= danoReal;
        System.out.println(nombre + " [Mago] activa su escudo mágico y recibe solo "
                + danoReal + " de daño. Salud restante: " + Math.max(0, salud));
    }

    /**
     * Lanza un hechizo especial (implementación de interfaz Magico).
     */
    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza su hechizo más poderoso: '" + hechizos + "'!");
    }

    /**
     * Aprende un nuevo hechizo (implementación de interfaz Magico).
     */
    @Override
    public void aprenderHechizo() {
        System.out.println(nombre + " estudia los antiguos libros y aprende un nuevo hechizo!");
        hechizos += " + Hechizo Nuevo";
    }

    public String getHechizos() {
        return hechizos;
    }

    public Arma getArma() {
        return arma;
    }
}