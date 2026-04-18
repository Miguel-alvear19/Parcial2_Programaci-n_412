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

    

}
