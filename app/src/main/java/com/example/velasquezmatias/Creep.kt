package com.example.velasquezmatias

open class Creep {

    var vida: Int = 0
        get() = field
        set(value){
            if(value > 500) {
                alertaVida()
            }
            else
                field = value;
        }
    var mana: Int = 0
    var ataque: Int = 0
    var defensa: Int = 0
    var velocidad: Int = 0
    var nivel : Nivel

    constructor(vida: Int, mana: Int, ataque: Int, defensa: Int, velocidad : Int, nivel : Nivel){
        this.vida = vida
        this.mana = mana
        this.ataque = ataque
        this.defensa = defensa
        this.velocidad = velocidad
        this.nivel = nivel
    }

    fun atacar(personaje : Personaje){
        var dañoTotal : Int = 0

        dañoTotal = this.ataque - personaje.defensa
        if(dañoTotal > 0){
            personaje.vida = personaje.vida - dañoTotal
            print("Se realizó un ataque de ${dañoTotal}. Vida de ${personaje.nombre}: ${personaje.vida}\n" )
            if(checkearVida(personaje)){
                print("Has sido derrotado!")
            }
        } else {
            personaje.vida = personaje.vida - 10;
            print("Tu defensa supera el ataque del creep! Recibes 10 de daño. Vida de ${personaje.nombre}: ${personaje.vida}\n")
            if(checkearVida(personaje)){
                print("Has sido derrotado!")
            }
        }
    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    private fun alertaVida(){
        print("La vida es superior a 100. Ingrese nuevamente\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque: ${this.ataque}, " +
                "defensa: ${this.defensa}, nivel: ${this.nivel.nivel}.\n"
    }
}