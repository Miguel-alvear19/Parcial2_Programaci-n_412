package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.Interfaces.Volador;
import com.parcial.claseAbstracta.Criatura;

/**
 * Clase Dragon
 * El dragón es una criatura poderosa que implementa la interfaz Volador.
 * Su ataque es especialmente fuerte: causa el doble de su fuerza base (fuerza * 2).
 * Usa composición con la clase Arma para potenciar sus ataques.
 */
public class Dragon extends Criatura implements Volador {

    private String escamas;


    private Arma arma;

    /**
     * Constructor del Dragon.
     *
     * @param nombre  Nombre del dragón.
     * @param salud   Puntos de salud.
     * @param fuerza  Fuerza base.
     * @param escamas Tipo de escamas (ej: "Escamas de Fuego").
     */
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.arma = null;
    }

    /**
     * Equipa un arma al dragón.
     *
     * @param arma El arma a equipar.
     */
    public void equiparArma(Arma arma) {
        this.arma = arma;
        System.out.println(nombre + " equipó: " + arma.getNombre());
    }

    /**
     * Desequipa el arma actual del dragón.
     */
    public void desequiparArma() {
        if (arma != null) {
            System.out.println(nombre + " desequipó: " + arma.getNombre());
            this.arma = null;
        }
    }

    /**
     * El dragón ataca con el doble de su fuerza base.
     * Si tiene arma equipada, también la usa para causar daño adicional.
     *
     * @param objetivo La criatura que recibe el ataque.
     */
    @Override
    public void atacar(Criatura objetivo) {
        int dano = fuerza * 2; // El dragón hace el doble de daño
        System.out.println(nombre + " [Dragón] ataca a " + objetivo.getNombre()
                + " con sus garras de fuego causando " + dano + " de daño!");
        objetivo.defender(dano);

        // Si tiene arma equipada, realiza un ataque adicional con ella
        if (arma != null) {
            arma.atacarConArma(objetivo);
        }
    }

    /**
     * El dragón se defiende reduciendo el daño recibido con sus escamas resistentes.
     * Las escamas absorben 5 puntos de daño.
     *
     * @param dano Daño recibido del atacante.
     */
    @Override
    public void defender(int dano) {
        int reduccion = 5; // Las escamas del dragón absorben parte del daño
        int danoReal = Math.max(0, dano - reduccion);
        salud -= danoReal;
        System.out.println(nombre + " [Dragón] recibe " + dano + " de daño, sus "
                + escamas + " absorben " + reduccion + ". Salud restante: " + Math.max(0, salud));
    }

    /**
     * El dragón despega y vuela (implementación de interfaz Volador).
     */
    @Override
    public void volar() {
        System.out.println(nombre + " extiende sus alas y despega hacia el cielo!");
    }

    /**
     * El dragón aterriza (implementación de interfaz Volador).
     */
    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza con fuerza haciendo temblar el suelo!");
    }

    public String getEscamas() {
        return escamas;
    }

    public Arma getArma() {
        return arma;
    }
}