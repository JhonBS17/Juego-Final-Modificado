/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Drugdu
 */
public class JugadorInutil extends Jugador{

    @Override
    public void EquiparArma(Arma arma) {
        armaEquipada=arma;
    }

    @Override
    public void Curar(int valorCura) {
        this.vida+=valorCura;
    }

    @Override
    public void Jugar(Mapa m, Jugador oponente) {
        System.out.print("El jugador no hizo nada");
    }
    
    @Override
    public void JugarPlayer1(Mapa m, Jugador oponente) {
        System.out.print("El jugador no hizo nada");
    }
    public void JugarPlayer2(Mapa m, Jugador oponente) {
        System.out.print("El jugador no hizo nada");
    }
    @Override
    public void JugarPlayer3(Mapa m, Jugador oponente) {
        System.out.print("El jugador no hizo nada");
    }
}
