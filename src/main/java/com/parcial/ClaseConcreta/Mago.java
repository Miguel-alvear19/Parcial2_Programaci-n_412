package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.Interfaces.IMagico;
import com.parcial.claseAbstracta.Criatura;


public class Mago extends Criatura implements IMagico {
    private Arma arma;
    private String hechizos;

    public Mago(String nombre, int salud, int fuerza, Arma arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
        this.hechizos = "";
    }

    @Override
    public void atacar(Criatura objetivo) {
        arma.atacarConArma(objetivo, fuerza);
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        System.out.println(nombre + " lanza un hechizo contra " + objetivo.getNombre());
        objetivo.defender(fuerza + 15);
    }

    @Override
    public void aprenderHechizo(String hechizo) {
        hechizos += hechizo + " ";
        System.out.println(nombre + " aprendió el hechizo: " + hechizo);
    }

    
}