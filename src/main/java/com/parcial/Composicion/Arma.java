package com.parcial.Composicion;

import com.parcial.claseAbstracta.Criatura;

public class Arma {
    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    public void atacarConArma(Criatura objetivo, int fuerzaBase) {
        objetivo.defender(fuerzaBase + dañoAdicional);
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }
}