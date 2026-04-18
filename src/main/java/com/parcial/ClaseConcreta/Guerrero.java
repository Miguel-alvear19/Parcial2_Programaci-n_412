package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.claseAbstracta.Criatura;

/**
 * Clase Guerrero
 * El guerrero ataca con su espada causando daño igual a su fuerza base.
 * Es una clase concreta que implementa los métodos abstractos de Criatura.
 * Usa composición con la clase Arma para equipar y usar su espada u otras armas.
 */
public class Guerrero extends Criatura {

    // Tipo de armadura o espada característica del guerrero
    private String armaDescripcion;

    // Arma equipada por composición (puede ser null)
    private Arma arma;

    /**
     * Constructor del Guerrero.
     *
     * @param nombre          Nombre del guerrero.
     * @param salud           Puntos de salud.
     * @param fuerza          Fuerza física base.
     * @param armaDescripcion Descripción del arma o estilo de combate.
     */
    public Guerrero(String nombre, int salud, int fuerza, String armaDescripcion) {
        super(nombre, salud, fuerza);
        this.armaDescripcion = armaDescripcion;
        this.arma = null;
    }

    /**
     * Equipa un arma al guerrero.
     *
     * @param arma El arma a equipar.
     */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " equipó: " + arma.getNombre());
    }

    /**
     * Desequipa el arma actual del guerrero.
     */
    public void desequiparArma() {
        if (arma != null) {
            System.out.println(nombre + " desequipó: " + arma.getNombre());
            this.arma = null;
        }
    }

    /**
     * El guerrero ataca con su espada causando daño igual a su fuerza.
     * Si tiene arma equipada, también la usa para daño adicional.
     *
     * @param objetivo La criatura que recibe el ataque.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza; // El guerrero causa daño igual a su fuerza base
        System.out.println(nombre + " [Guerrero] ataca con " + armaDescripcion
                + " a " + objetivo.getNombre() + " causando " + dano + " de daño!");
        objetivo.defender(dano);

        // Si tiene arma equipada, aplica daño adicional
        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    /**
     * El guerrero se defiende con su armadura que reduce el daño en 2 puntos.
     *
     * @param dano Daño recibido.
     */
    @Override
    public void defender(int dano) {
        int armadura = 2; // La armadura del guerrero absorbe algo de daño
        int danoReal = Math.max(0, dano - armadura);
        salud -= danoReal;
        System.out.println(nombre + " [Guerrero] bloquea con su armadura y recibe "
                + danoReal + " de daño. Salud restante: " + Math.max(0, salud));
    }

    public String getArmaDescripcion() {
        return armaDescripcion;
    }

    public Arma getArma() {
        return arma;
    }
}