package com.example.velasquezmatias

class Lobo() : Creep(vida= 0, mana = 0,ataque = 0, defensa = 0, velocidad = 0, Nivel(nivel = 0)){

    var colorPelaje : String = ""


    constructor(vida: Int,mana:Int,ataque:Int,defensa:Int, velocidad : Int,colorPelaje: String, nivel : Nivel): this (){
        this.vida = vida
        this.mana = mana
        this.ataque = ataque
        this.defensa = defensa
        this.velocidad = velocidad
        this.colorPelaje= colorPelaje
        this.nivel = nivel
    }


    fun morder(personaje : Personaje) {
        var dañoMordida = 10
        var probDoble: Int = (0..10).random()

        personaje.vida = personaje.vida - dañoMordida
        print("Se realizó un ataque de mordida de ${dañoMordida}. Vida de ${personaje.nombre}: ${personaje.vida}\n")

        if (probDoble > 8){
            print("El lobo mordió nuevamente!\n")
            personaje.vida = personaje.vida - dañoMordida
            print("Se realizó un ataque de mordida de ${dañoMordida}. Vida de ${personaje.nombre}: ${personaje.vida}\n")
        }
        if(checkearVida(personaje)){
            print("Has sido derrotado!")
        }
    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    @Override fun hablar(){
        print("Wof Wof \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*4)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }

    @Override fun bonoNivel(){
        var nuevaVida :Int = 0
        var nuevaMana :Int = 0
        var nuevoAtaque :Int = 0
        var nuevaDefensa :Int = 0

        nuevaVida = this.vida + (this.nivel.nivel*5);
        nuevaMana = this.mana + (this.nivel.nivel*3)
        nuevoAtaque = this.ataque + (this.nivel.nivel * 2)
        nuevaDefensa = this.defensa + (this.nivel.nivel * 2)

        this.vida = nuevaVida
        this.mana = nuevaMana
        this.ataque = nuevoAtaque
        this.defensa = nuevaDefensa

        print("Bonoficación de lobo por nivel:\n")
        print("Vida: ${this.vida} (+${this.nivel.nivel*5})\n")
        print("Mana: ${this.mana} (+${this.nivel.nivel*2})\n")
        print("Ataque: ${this.ataque} (+${this.nivel.nivel*4})\n")
        print("Defensa: ${this.defensa} (+${this.nivel.nivel*2})\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, colorPelaje: ${this.colorPelaje}, " +
                "velocidad: ${this.velocidad}, nivel: ${this.nivel.nivel}.\n"
    }
}