package com.example.velasquezmatias

open class Esqueleto() : Creep(vida= 0, mana = 0,ataque = 0, defensa = 0, velocidad = 0,Nivel(nivel = 0)){

    var dureza : Int = 0

    constructor(vida: Int,mana:Int,ataque:Int,defensa:Int,dureza: Int, velocidad : Int, nivel : Nivel): this (){
        this.vida = vida
        this.mana = mana
        this.ataque = ataque
        this.dureza= dureza
        this.defensa = defensa + dureza
        this.velocidad = velocidad
        this.nivel = nivel
    }

    fun reconstruirse(){
        var costo : Int = 50

        if(validarCosto(costo)){
            this.vida = 100
            print("El esqueleto se reconstruyó y recuperó por completo su vida! (${this.vida})")
        }
    }

    private fun validarCosto(costo: Int): Boolean{
        return this.mana >= costo
    }

    @Override fun hablar(){
        print("Plank Plank \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*2)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }

    @Override fun bonoNivel(){
        var nuevaVida :Int = 0
        var nuevaMana :Int = 0
        var nuevoAtaque :Int = 0
        var nuevaDefensa :Int = 0

        nuevaVida = this.vida + (this.nivel.nivel*7);
        nuevaMana = this.mana + (this.nivel.nivel*5)
        nuevoAtaque = this.ataque + (this.nivel.nivel * 3)
        nuevaDefensa = this.defensa + (this.nivel.nivel * 4)

        this.vida = nuevaVida
        this.mana = nuevaMana
        this.ataque = nuevoAtaque
        this.defensa = nuevaDefensa

        print("Bonoficación de Esqueleto por nivel:\n")
        print("Vida: ${this.vida} (+${this.nivel.nivel*7})\n")
        print("Mana: ${this.mana} (+${this.nivel.nivel*5})\n")
        print("Ataque: ${this.ataque} (+${this.nivel.nivel*3})\n")
        print("Defensa: ${this.defensa} (+${this.nivel.nivel*4})\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, dureza: ${this.dureza}, " +
                "velocidad: ${this.velocidad}, nivel: ${nivel.nivel}.\n"
    }
}