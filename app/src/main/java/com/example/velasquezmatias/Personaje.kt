package com.example.velasquezmatias

class Personaje {

    var id: Int = 0;
    var nombre: String = ""
    var clase: String = ""
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
    var jugador : Jugador // Relación de composición con jugador.


    constructor(id: Int, nombre: String, clase: String, vida: Int, mana: Int, ataque: Int, defensa: Int, velocidad: Int, jugador : Jugador){
        this.id=id;
        this.nombre = nombre
        this.clase = clase;
        this.vida = vida
        this.mana = mana
        this.ataque = ataque
        this.defensa = defensa
        this.velocidad = velocidad
        this.jugador = jugador
    }

    fun atacar(creep : Creep){
        var dañoTotal : Int = 0

        dañoTotal = this.ataque - creep.defensa
        if(dañoTotal > 0){
            creep.vida = creep.vida - dañoTotal
            print("Se realizó un ataque de ${dañoTotal}. Vida del creep: ${creep.vida} \n")
            if(checkearVida(creep)){
                print("Has derrotado al creep!")
            }
        }
        else{
            creep.vida = creep.vida - 20
            print("La defensa del creep supera tu ataque! Realizas 20 de daño. Vida del creep: ${creep.vida}\n")
            if(checkearVida(creep)){
                print("Has derrotado al creep!")
            }
        }
    }

    fun subirDefensa(){
        var maxDefensa : Int = 100
        var defensaAumentada: Int = 5
        var costo : Int = 5
        var defensaTotal : Int = maxDefensa - defensaAumentada

        if(this.defensa < maxDefensa){
            if(validarCosto(costo)){
                print("Consumiste ${costo} de mana \n")
                this.mana = this.mana - costo
                if(this.defensa <= defensaTotal) {
                    this.defensa = this.defensa + defensaAumentada;
                    print("Tu personaje aumentó la defensa, defensa actual: ${this.defensa} \n")
                } else {
                    this.defensa = this.defensa + (maxDefensa - this.defensa)
                    print("Tu personaje aumentó la defensa, defensa actual: ${this.defensa} \n")
                }
            }
            else
                print("Necesitas ${costo} de mana para subir tu defensa. Mana actual: ${this.mana} \n")
        }
        else
            print("Ya posee el máximo de defensa\n")
    }

    fun curar(){

        var maxVida : Int = 100
        var vidaCurada : Int = 40
        var costo : Int = 10;
        var curaTotal: Int = maxVida - vidaCurada

        if(this.vida < maxVida){
            if(validarCosto(costo)){
                print("Consumiste ${costo} de mana \n")
                this.mana = this.mana - costo
                if (this.vida <= curaTotal) {
                    this.vida = this.vida + vidaCurada;
                    print("Tu personaje se curó, vida actual: ${this.vida} \n")
                } else {
                    this.vida = this.vida + (maxVida - this.vida)
                    print("Tu personaje se curó, vida actual: ${this.vida} \n")
                }
            }
            else
                print("Necesitas ${costo} de mana para curarte. Mana actual: ${this.mana} \n")
        }
        else
            print("Ya posee el máximo de vida \n")
    }

    private fun validarCosto(costo: Int): Boolean{
        return this.mana >= costo
    }

    private fun alertaVida(){
        print("La vida es superior a 100. Ingrese nuevamente\n")
    }

    private fun checkearVida(creep:Creep) : Boolean{
        return creep.vida <= 0
    }

    override fun toString(): String {
        return "ID: ${this.id}, nombre: ${this.nombre}, clase: ${this.clase}, " +
                "vida: ${this.vida}, mana: ${this.mana}, " +
                "ataque: ${this.ataque}, defensa: ${this.defensa}. " +
                "Pertenece a ${jugador.nickname}, Id ${jugador.id}. \n"
    }
}