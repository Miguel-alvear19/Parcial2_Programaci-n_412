package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.Interfaces.IVolador;
import com.parcial.claseAbstracta.Criatura;


public class Dragon extends Criatura implements IVolador {
    private String escamas;
    private Arma arma;

    public Dragon(String nombre, int salud, int fuerza, Arma arma) {
        super(nombre, salud, fuerza);
        this.escamas = "Rojas";
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        arma.atacarConArma(objetivo, fuerza);
    }

    @Override
    public void volar() {
        System.out.println(nombre + " está volando.");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza.");
    }
}