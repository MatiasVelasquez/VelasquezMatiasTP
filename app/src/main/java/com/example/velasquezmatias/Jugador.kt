package com.example.velasquezmatias

open class Jugador {

    var id : Int = 0
    var nickname: String = ""
        get() = field
        set(value){
            if(value == "Admin" || value == "Administrador") {
                alerta(value)
            }
            else
                field = value;
        }
    var edad: Int = 0
        get() = field
        set(value){
            if(value < 18) {
                alerta()
                }
            else
                field = value;
        }
    var mail: String = ""

     constructor(id: Int, nickname: String, edad: Int, mail: String){
        this.id = id;
        this.nickname = nickname;
        this.edad = edad;
        this.mail = mail;
    }

    private  fun alerta(){
        print("Usted es menor de edad, debe salir inmediatamente del juego.\n")
    }

    private fun alerta(nickname : String){
        print("El nickname ${nickname} no está disponible para usar.\n")
    }

    override fun toString(): String {
        return "ID: ${this.id} nickname: ${this.nickname}, edad ${this.edad} " +
                "mail:  ${this.mail}\n"
    }

}