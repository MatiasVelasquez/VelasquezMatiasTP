package com.example.velasquezmatias

fun main() {


    var jugador1 = Jugador(id=1,nickname="Matias",edad=25,mail="mail@mail.com");

    var Braun = Personaje(id=1,nombre="Braun",clase="Titan",vida=50,mana=100,ataque=30,defensa=72, velocidad = 2, jugador1)
    var nivel1 = Nivel(nivel=1);
    var nivel2 = Nivel(nivel=2);
    var lobo1 = Lobo(vida = 50,mana= 50,ataque=30, defensa = 15,velocidad = 4,colorPelaje = "Azul",nivel1)
    var araña1 = Araña(vida = 30,mana= 60,ataque=25, defensa = 5,velocidad = 2,gradoVeneno = 2,nivel2)
    var esqueleto1 = Esqueleto(vida = 80,mana= 100,ataque=35, defensa = 20, dureza = 10,velocidad = 3,nivel2)

    /* Herencia: Creep -> Lobo, Araña, Esqueleto*/
    println(jugador1);
    println(Braun);
    println(lobo1);
    println(araña1);
    println(esqueleto1);

    lobo1.hablar()
    esqueleto1.hablar()
    araña1.hablar()

    lobo1.avanzar()
    araña1.avanzar()
    esqueleto1.avanzar()

    lobo1.bonoNivel()
    araña1.bonoNivel()
    esqueleto1.bonoNivel()

    println(lobo1);
    println(araña1);
    println(esqueleto1);

}