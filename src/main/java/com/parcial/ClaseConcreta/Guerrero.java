package com.parcial.ClaseConcreta;

import com.parcial.Composicion.Arma;
import com.parcial.claseAbstracta.Criatura;


public class Guerrero extends Criatura {
    private Arma arma;

    public Guerrero(String nombre, int salud, int fuerza, Arma arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        arma.atacarConArma(objetivo, fuerza);
    }
}