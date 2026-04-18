# Explicación de las Clases del Proyecto

## Clase `Main`
Esta clase contiene el método principal del programa y la lógica para simular una batalla entre dos criaturas. Utiliza el método `simularBatalla` para gestionar los turnos y determinar el ganador.

## Clase Abstracta `Criatura`
Define las propiedades y comportamientos básicos de una criatura, como su nombre, salud y fuerza. También incluye métodos para atacar, defender y verificar si la criatura está viva. Es la clase base para las demás criaturas.

## Clase `Guerrero`
Extiende la clase `Criatura` y representa a un guerrero. Utiliza un arma para atacar, lo que le permite infligir daño adicional a sus oponentes.

## Clase `Mago`
Extiende la clase `Criatura` e implementa la interfaz `IMagico`. Representa a un mago que puede lanzar hechizos y aprender nuevos. También utiliza un arma para atacar.

## Clase `Dragon`
Extiende la clase `Criatura` e implementa la interfaz `IVolador`. Representa a un dragón que puede volar y aterrizar. También utiliza un arma para atacar y tiene escamas de un color específico.

## Clase `Arma`
Define un arma con un nombre y un daño adicional. Proporciona el método `atacarConArma` para infligir daño a una criatura combinando la fuerza base y el daño adicional del arma.

## Interfaz `IMagico`
Define los métodos que deben implementar las clases mágicas, como lanzar hechizos y aprender nuevos.

## Interfaz `IVolador`
Define los métodos que deben implementar las clases voladoras, como volar y aterrizar.

## Diagrama de Clases

```mermaid
classDiagram
    class Criatura {
        - String nombre
        - int salud
        - int fuerza
        + Criatura(String, int, int)
        + String getNombre()
        + int salud()
        + void atacar(Criatura)
        + void defender(int)
        + boolean estaViva()
    }

    class Guerrero {
        - Arma arma
        + Guerrero(String, int, int, Arma)
        + void atacar(Criatura)
    }

    class Mago {
        - Arma arma
        - String hechizos
        + Mago(String, int, int, Arma)
        + void atacar(Criatura)
        + void lanzarHechizo(Criatura)
        + void aprenderHechizo(String)
    }

    class Dragon {
        - String escamas
        - Arma arma
        + Dragon(String, int, int, Arma)
        + void atacar(Criatura)
        + void volar()
        + void aterrizar()
    }

    class Arma {
        - String nombre
        - int dañoAdicional
        + Arma(String, int)
        + void atacarConArma(Criatura, int)
        + int getDañoAdicional()
    }

    class IMagico {
        + void lanzarHechizo(Criatura)
        + void aprenderHechizo(String)
    }

    class IVolador {
        + void volar()
        + void aterrizar()
    }

    Criatura <|-- Guerrero
    Criatura <|-- Mago
    Criatura <|-- Dragon
    Mago ..|> IMagico
    Dragon ..|> IVolador
    Guerrero o-- Arma
    Mago o-- Arma
    Dragon o-- Arma
```