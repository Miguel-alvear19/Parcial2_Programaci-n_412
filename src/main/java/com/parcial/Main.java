package com.parcial;

import com.parcial.ClaseConcreta.Dragon;
import com.parcial.ClaseConcreta.Guerrero;
import com.parcial.ClaseConcreta.Mago;
import com.parcial.Composicion.Arma;
import com.parcial.Interfaces.Magico;
import com.parcial.Interfaces.Volador;
import com.parcial.claseAbstracta.Criatura;

/**
 * Clase Principal (Main)
 * Crea las criaturas, las equipa con armas y simula batallas entre ellas.
 * Muestra el resultado de cada ronda y el ganador final.
 */
public class Main {

    /**
     * Simula una batalla entre dos criaturas.
     * La batalla continúa ronda a ronda hasta que una de las criaturas muera.
     * Se alternan los ataques: criatura1 ataca primero en cada ronda.
     *
     * @param criatura1 Primera criatura participante.
     * @param criatura2 Segunda criatura participante.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n========================================");
        System.out.println("  BATALLA: " + criatura1.getNombre()
                + " VS " + criatura2.getNombre());
        System.out.println("========================================");

        // Si las criaturas tienen habilidades especiales, las usan antes de la batalla
        if (criatura1 instanceof Volador) {
            ((Volador) criatura1).volar(); // El dragón vuela antes de atacar
        }
        if (criatura2 instanceof Magico) {
            ((Magico) criatura2).lanzarHechizo(); // El mago lanza su hechizo de apertura
        }

        int ronda = 1;

        // La batalla continúa mientras ambas criaturas estén vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            // Criatura 1 ataca a Criatura 2
            if (criatura1.estaViva()) {
                criatura1.atacar(criatura2);
            }

            // Criatura 2 contraataca si sigue viva
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
            }

            ronda++;

            // Seguridad: evitar bucle infinito si ambas tienen salud infinita
            if (ronda > 100) {
                System.out.println("La batalla fue demasiado larga. ¡Empate!");
                return;
            }
        }

        // Si el dragón participó y ganó, aterriza
        if (criatura1 instanceof Volador && criatura1.estaViva()) {
            ((Volador) criatura1).aterrizar();
        }

        // Mostrar el resultado final
        System.out.println("\n========================================");
        if (!criatura1.estaViva() && !criatura2.estaViva()) {
            System.out.println("  RESULTADO: ¡Ambas criaturas murieron! EMPATE.");
        } else if (criatura1.estaViva()) {
            System.out.println("  GANADOR: " + criatura1.getNombre()
                    + " con " + criatura1.getSalud() + " puntos de salud restantes.");
        } else {
            System.out.println("  GANADOR: " + criatura2.getNombre()
                    + " con " + criatura2.getSalud() + " puntos de salud restantes.");
        }
        System.out.println("========================================\n");
    }

    /**
     * Método principal. Crea criaturas, las equipa y simula batallas entre ellas.
     *
     * @param args Argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {

        // --- Crear armas ---
        Arma espadaLarga    = new Arma("Espada Larga", 8);
        Arma bastonMagico   = new Arma("Bastón Mágico", 5);
        Arma garrasDeFuego  = new Arma("Garras de Fuego", 10);

        // --- Crear criaturas ---
        Dragon dragon   = new Dragon("Ignis", 150, 30, "Escamas de Fuego");
        Mago   mago     = new Mago("Merlin", 80, 25, "Bola de Fuego");
        Guerrero guerrero = new Guerrero("Thor", 120, 20, "su espada de acero");

        // --- Equipar armas a las criaturas (Composición) ---
        dragon.equiparArma(garrasDeFuego);
        mago.equiparArma(bastonMagico);
        guerrero.equiparArma(espadaLarga);

        // --- El mago aprende un hechizo nuevo antes de las batallas ---
        mago.aprenderHechizo();

        // ============================
        // Batalla 1: Dragón vs Guerrero
        // ============================
        simularBatalla(dragon, guerrero);

        // Restaurar salud para la siguiente batalla (reiniciar criaturas)
        Dragon dragon2    = new Dragon("Ignis", 150, 30, "Escamas de Fuego");
        Mago   mago2      = new Mago("Merlin", 80, 25, "Bola de Fuego");
        Guerrero guerrero2 = new Guerrero("Thor", 120, 20, "su espada de acero");

        dragon2.equiparArma(new Arma("Garras de Fuego", 10));
        mago2.equiparArma(new Arma("Bastón Mágico", 5));
        guerrero2.equiparArma(new Arma("Espada Larga", 8));

        // ============================
        // Batalla 2: Mago vs Guerrero
        // ============================
        simularBatalla(mago2, guerrero2);

        // Nuevas instancias para la tercera batalla
        Dragon dragon3 = new Dragon("Ignis", 150, 30, "Escamas de Fuego");
        Mago   mago3   = new Mago("Merlin", 80, 25, "Bola de Fuego");

        dragon3.equiparArma(new Arma("Garras de Fuego", 10));
        mago3.equiparArma(new Arma("Bastón Mágico", 5));

        // ============================
        // Batalla 3: Dragón vs Mago
        // ============================
        simularBatalla(dragon3, mago3);
    }
}
