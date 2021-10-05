package com.example.velasquezmatias

class Araña() : Creep(vida= 0, mana = 0,ataque = 0, defensa = 0, velocidad = 0,Nivel(nivel = 0)) {

    var gradoVeneno: Int = 0

    constructor(vida: Int,mana:Int,ataque:Int,defensa:Int,velocidad : Int,gradoVeneno: Int,nivel : Nivel): this (){
        this.vida = vida
        this.mana = mana
        this.ataque = ataque
        this.defensa = defensa
        this.velocidad = velocidad
        this.gradoVeneno= gradoVeneno
        this.nivel = nivel
    }

    fun envenenar(personaje: Personaje) {
        var probVeneno: Int = (0..10).random()
        var dañoTotal: Int = gradoVeneno + 1

        print("${personaje.nombre} recibió un picotazo venenozo!\n")
        personaje.vida = personaje.vida - 1


        if(probVeneno > 3){
            print("Envenenado!\n")
        }

        while(probVeneno > 3){
            personaje.vida = personaje.vida - dañoTotal
            print("El veneno hace efecto! -${dañoTotal} vida\n")
            probVeneno = (0..10).random()
        }
        print("Vida restante: ${personaje.vida}\n")
        if(checkearVida(personaje)){
            print("Has sido derrotado")
        }

    }

    private fun checkearVida(personaje: Personaje) : Boolean{
        return personaje.vida <= 0
    }

    @Override fun hablar(){
        print("Crii \n")
    }

    @Override fun avanzar(){
        var distanciaRecorrida : Int = 0;

        distanciaRecorrida = distanciaRecorrida + (this.velocidad*6)
        print("Distancia recorrida: ${distanciaRecorrida}\n")
    }

    @Override fun bonoNivel(){
        var nuevaVida :Int = 0
        var nuevaMana :Int = 0
        var nuevoAtaque :Int = 0
        var nuevaDefensa :Int = 0

        nuevaVida = this.vida + (this.nivel.nivel*3);
        nuevaMana = this.mana + (this.nivel.nivel*2)
        nuevoAtaque = this.ataque + (this.nivel.nivel * 3)
        nuevaDefensa = this.defensa + (this.nivel.nivel * 2)

        this.vida = nuevaVida
        this.mana = nuevaMana
        this.ataque = nuevoAtaque
        this.defensa = nuevaDefensa

        print("Bonoficación de araña por nivel:\n")
        print("Vida: ${this.vida} (+${this.nivel.nivel*3})\n")
        print("Mana: ${this.mana} (+${this.nivel.nivel*2})\n")
        print("Ataque: ${this.ataque} (+${this.nivel.nivel*3})\n")
        print("Defensa: ${this.defensa} (+${this.nivel.nivel*2})\n")
    }

    override fun toString(): String {
        return "Vida: ${this.vida}, mana: ${this.mana}, ataque ${this.ataque}, " +
                "defensa: ${this.defensa}, " +
                "velocidad: ${this.velocidad}, tipoVeneno:  ${this.gradoVeneno}" +
                ", nivel: ${this.nivel.nivel}.\n"
    }
}