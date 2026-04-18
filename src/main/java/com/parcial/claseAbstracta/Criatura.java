package com.parcial.claseAbstracta;

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public String getNombre() { return nombre; }

    public int salud() { return salud; }

    public void atacar(Criatura objetivo) {
        objetivo.defender(fuerza);
    }

    public void defender(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }

    public boolean estaViva() {
        return salud > 0;
    }

    

    protected String nombre;
    
    protected int salud;

    protected int fuerza;

    /**
     * Constructor de la clase Criatura.
     *
     * @param nombre Nombre de la criatura.
     * @param salud  Puntos de salud iniciales.
     * @param fuerza Fuerza base para calcular ataques.
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    /**
     * Método abstracto: cada criatura define cómo ataca a su objetivo.
     *
     * @param objetivo La criatura que recibe el ataque.
     */
    public abstract void atacar(Criatura objetivo);

    /**
     * Método abstracto: cada criatura define cómo se defiende al recibir daño.
     *
     * @param dano Cantidad de daño recibido (equivale a la fuerza del atacante).
     */
    public abstract void defender(int dano);

    /**
     * Método concreto: indica si la criatura sigue viva.
     *
     * @return true si la salud es mayor a 0, false si está muerta.
     */
    public boolean estaViva() {
        return salud > 0;
    }


    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }


    protected void setSalud(int salud) {
        this.salud = salud;
    }
}