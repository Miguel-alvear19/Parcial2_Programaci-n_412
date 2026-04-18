package com.parcial;

import com.parcial.ClaseConcreta.Guerrero;
import com.parcial.ClaseConcreta.Mago;
import com.parcial.claseAbstracta.Criatura;
import com.parcial.Composicion.Arma;
import com.parcial.ClaseConcreta.Dragon;
import com.parcial.Interfaces.IMagico;
import com.parcial.Interfaces.IVolador;

public class Main {
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("⚔️ ¡Comienza la batalla entre " + criatura1.getNombre() + " y " + criatura2.getNombre() + "!");

        int turno = 1;
        // La batalla continúa mientras ambas criaturas estén vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Criatura 1 ataca
            System.out.println("👉 " + criatura1.getNombre() + " ataca a " + criatura2.getNombre());
            criatura1.atacar(criatura2);
            System.out.println("💀 Salud de " + criatura2.getNombre() + ": " + criatura2.salud());

            // Verificar si criatura2 murió
            if (!criatura2.estaViva()) break;

            // Criatura 2 ataca
            System.out.println("👉 " + criatura2.getNombre() + " ataca a " + criatura1.getNombre());
            criatura2.atacar(criatura1);
            System.out.println("💀 Salud de " + criatura1.getNombre() + ": " + criatura1.salud());

            turno++;
        }

        // Resultado final
        System.out.println("\n🏆 ¡La batalla ha terminado!");
        if (criatura1.estaViva()) {
            System.out.println("🎉 " + criatura1.getNombre() + " ha ganado.");
        } else {
            System.out.println("🎉 " + criatura2.getNombre() + " ha ganado.");
        }
    }

    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("Conan", 100, 20, new Arma("Espada", 10));
        Mago mago = new Mago("Merlín", 80, 15, new Arma("Báculo", 5));
        Dragon dragon = new Dragon("Smaug", 150, 25, new Arma("Fuego", 20));

        simularBatalla(guerrero, dragon);
    }
}