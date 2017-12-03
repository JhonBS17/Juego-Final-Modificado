/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegofinal;

import Models.ArmaFactory;
import Models.Jugador;
import Models.JugadorInutil;
import Models.JugadorPrueba;
import Models.Mapa;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Drugdu
 */
public class JuegoFinal {

    static Mapa m;
    static Jugador j1;
    static Jugador j2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader br = new InputStreamReader(System.in);
        Random R= new Random();
        j1= new JugadorPrueba();
        j1.EquiparArma(ArmaFactory.CreateArma(R.nextInt(10)));
        j1.setChar('1');
        j2= new JugadorInutil();
        j2.EquiparArma(ArmaFactory.CreateArma(R.nextInt(10)));
        j2.setChar('2');
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese 1, 2, 3 o 4  segun el perfil que desee: ");
        int s=sc.nextInt();
        switch(s){
            case 1:{
                j1.setTipo_jugador("Médico");
                break;
            }case 2:{
                j1.setTipo_jugador("Saludable");
                break;
            }case 3:{
                j1.setTipo_jugador("Rango Alto");
                break;
            }case 4 :{
                j1.setTipo_jugador(" ");break;
            }case 5:{
                j1.setTipo_jugador("Destructor");
                break;
            }default:{
            j1.setTipo_jugador(" "); break; 
            }
            
        }
        CrearMapa();
        
        while(j2.isVivo()&&j1.isVivo())
        {
            j1.ImprimirJugador();
            j2.ImprimirJugador();
            m.ImprimirMapa();

            System.out.println("");
            String o=j1.getTipo_Jugador();
            switch(o){
                case "Médico":{
                    j1.JugarPlayer1(m, j2);
                    break;
                }case "Saludable":{
                    j1.JugarPlayer2(m, j2);
                    break;
                }case "Cuerpo a cuerpo":{
                    j1.JugarPlayer3(m, j2);
                    break;
                }default:{
                    j1.Jugar(m, j2);
                    break;
                }
            }
            System.out.println("");
            j2.Jugar(m,j1);
            System.out.println("");
            //br.read(); esto obliga a que exista un enter entre turnos
        }       
    }

    private static void CrearMapa() {
        m= new Mapa(); 
        m.ubicarJugador(1,1,j1);
        m.ubicarJugador(23,23,j2);
    }
    
}
