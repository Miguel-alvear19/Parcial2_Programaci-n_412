package com.parcial.Composicion;

import com.parcial.claseAbstracta.Criatura;

/**
 * Clase Arma
 * Representa un arma que las criaturas pueden usar en batalla.
 * Se usa composición (y no herencia) para agregar esta funcionalidad
 * a las criaturas, lo que permite equipar o desequipar armas dinámicamente.
 */
public class Arma {

    // Nombre del arma (ej: "Espada", "Bastón Mágico", "Garra de Fuego")
    private String nombre;

    // Daño adicional que proporciona el arma al atacar
    private int danoAdicional;

    /**
     * Constructor de la clase Arma.
     *
     * @param nombre       Nombre del arma.
     * @param danoAdicional Daño extra que agrega el arma al ataque.
     */
    public Arma(String nombre, int danoAdicional) {
        this.nombre = nombre;
        this.danoAdicional = danoAdicional;
    }

    /**
     * Realiza un ataque usando el arma contra una criatura objetivo.
     * Muestra un mensaje describiendo el ataque.
     *
     * @param objetivo La criatura que recibe el ataque del arma.
     */
    public void atacarConArma(Criatura objetivo) {
        System.out.println("  [Arma] Atacando con " + nombre
                + " causando " + danoAdicional + " de daño adicional a " + objetivo.getNombre());
        objetivo.defender(danoAdicional);
    }

    /**
     * Retorna el daño adicional que proporciona el arma.
     *
     * @return Daño adicional del arma.
     */
    public int getDanoAdicional() {
        return danoAdicional;
    }

    /**
     * Retorna el nombre del arma.
     *
     * @return Nombre del arma.
     */
    public String getNombre() {
        return nombre;
    }
}