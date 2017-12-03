
package Models;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JugadorPrueba extends Jugador {

    @Override
    public void EquiparArma(Arma arma) {
        super.armaEquipada = arma;
    }

    @Override
    public void Curar(int valorCura) {
        if (super.vida + valorCura >= 100) {
            super.vida = 100;
        } else {
            super.vida += valorCura;
        }
    }

    @Override
    public void Jugar(Mapa m, Jugador oponente) {
        int j1[], j2[];
        j1 = m.obtenerCoordenadas(this);
        j2 = m.obtenerCoordenadas(oponente);
        //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable) m.obtenerCasilla(j1[0], j1[1])).Desocupar();
        if (j1[0] < j2[0]) {
            j1[0]++;
        }
        if (j1[1] != j2[1] - armaEquipada.Rango) {
            System.out.print("jugador se mueve a (" + j1[0] + "," + (++j1[1]) + ")");
        } else {
            this.atacar(oponente);
            System.out.print("Se ha hecho un ataque");
        }

        //vamos a mover al jugador mas cerca al otro jugador
        ((IOcupable) m.obtenerCasilla(j1[0], j1[1])).Ocupar(this);
    }
    
    public void JugarPlayer1(Mapa m, Jugador oponente) {
        int j1[], j2[];
        j1 = m.obtenerCoordenadas(this);
        j2 = m.obtenerCoordenadas(oponente);
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Desocupar();
        m.VaciarCasilla(j1[0],j1[1]);
        if (this.vida<=50){
            if (String.valueOf((m.obtenerCasilla(j1[0]+1,j1[1]+1)).getClass()).equals("class Models.EspacioCura")) {
                j1[0]++;
                j1[1]++;
                EspacioCura ec=(EspacioCura)m.obtenerCasilla(j1[0],j1[1]);
                this.Curar(ec.valorCura);
                m.VaciarCasilla(j1[0],j1[1]);
                System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") porque encontró una cura");
            } else if (String.valueOf((m.obtenerCasilla(j1[0]+1,j1[1])).getClass()).equals("class Models.EspacioCura")) {
                j1[0]++;  
                EspacioCura ec=(EspacioCura)m.obtenerCasilla(j1[0],j1[1]);
                this.Curar(ec.valorCura);
                m.VaciarCasilla(j1[0],j1[1]);
                System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") porque encontró una cura");
            } else if (String.valueOf((m.obtenerCasilla(j1[0],j1[1]+1)).getClass()).equals("class Models.EspacioCura")) {
                j1[1]++;
                EspacioCura ec=(EspacioCura)m.obtenerCasilla(j1[0],j1[1]);
                this.Curar(ec.valorCura);
                m.VaciarCasilla(j1[0],j1[1]);
                System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") porque encontró una cura");
            } else {
                if (Math.abs(j1[1]-j2[1])<=oponente.armaEquipada.Rango) {
                    if (!String.valueOf((m.obtenerCasilla(j1[0],j1[1]-1)).getClass()).equals("class Models.EspacioBorde")) {
                        j1[1]--;
                        System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") para salir del rango");
                    } else if (!String.valueOf((m.obtenerCasilla(j1[0]-1,j1[1])).getClass()).equals("class Models.EspacioBorde")) {
                        j1[0]--;
                        System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") para salir del rango");
                    } else if (!String.valueOf((m.obtenerCasilla(j1[0]-1,j1[1]-1)).getClass()).equals("class Models.EspacioBorde")) {
                        j1[0]--;
                        j1[1]--;
                        System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") para salir del rango");
                    }
                }else{
                    j1[0]++;
                    j1[1]++;
                    System.out.print("El jugador se mueve a ("+j1[0]+","+(j1[1])+") normalmente");
                }
            }
        } else {
            if (j1[0]<j2[0]) {
                j1[0]++;
            }
            if (j1[1]!=j2[1]-armaEquipada.Rango) {
                System.out.print("El jugador se mueve a ("+j1[0]+","+(++j1[1])+") normalmente");
            } else {
                this.atacar(oponente);
                System.out.print("Se ha hecho un ataque");
            }
        }
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Ocupar(this);
    }
public void JugarPlayer2(Mapa m, Jugador oponente) {
        int j1[],j2[];
        j1 = m.obtenerCoordenadas(this);
        j2 = m.obtenerCoordenadas(oponente);
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Desocupar();
        m.VaciarCasilla(j1[0], j1[1]);
        if (this.vida<=40 && Math.abs(j1[1]-j2[1])<=oponente.armaEquipada.Rango) {
            this.armaEquipada.Fuerza=30;
            this.vida+=10;
            System.out.print("El jugador está ganando fuerzas");
        }else{
            if (j1[0]<j2[0]){
                j1[0]++;
            }
            if (j1[1]!=j2[1]-armaEquipada.Rango) {
                System.out.print("El jugador se mueve a ("+j1[0]+","+(++j1[1])+")");
            }else{
                this.atacar(oponente);
                System.out.print("Se ha hecho un ataque");
            }
        }
        ((IOcupable)m.obtenerCasilla(j1[0],j1[1])).Ocupar(this);
    }
public void JugarPlayer3(Mapa m, Jugador oponente){
        int j1[],j2[];
        j1 = m.obtenerCoordenadas(this);
        j2 = m.obtenerCoordenadas(oponente);
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Desocupar();
        m.VaciarCasilla(j1[0],j1[1]);
        oponente.armaEquipada.Rango++;
        if (oponente.armaEquipada.Rango> this.armaEquipada.Rango){
            this.armaEquipada.Rango+=5;
            this.armaEquipada.Fuerza+=5;
            System.out.println("Aumentando rango del Jugador");
        }else{
            if (j1[0]<j2[0]){
                j1[0]++;
            }
            if (j1[1]!=j2[1]-armaEquipada.Rango) {
                System.out.print("jugador se mueve a ("+j1[0]+","+(++j1[1])+")");
            } else {
                this.atacar(oponente);
                System.out.print("Se ha hecho un ataque");
            }
    }
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Ocupar(this);
}
    public void JugarPlayer4(Mapa m, Jugador oponente){
        int j1[],j2[];
        j1 = m.obtenerCoordenadas(this);
        j2 = m.obtenerCoordenadas(oponente);
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Desocupar();
        m.VaciarCasilla(j1[0],j1[1]);
        oponente.armaEquipada.Fuerza+=5;
        if (oponente.armaEquipada.Fuerza> this.armaEquipada.Fuerza){
            this.armaEquipada.Fuerza+=5;
            System.out.println("Aumentando la fuerza del jugador ");
        }else{
            if (j1[0]<j2[0]){
                j1[0]++;
            }
            if (j1[1]!=j2[1]-armaEquipada.Rango) {
                System.out.print("jugador se mueve a ("+j1[0]+","+(++j1[1])+")");
            } else {
                this.atacar(oponente);
                System.out.print("Se ha hecho un ataque");
            }
    }
        ((IOcupable) m.obtenerCasilla(j1[0],j1[1])).Ocupar(this);
    }

    private void atacar(Jugador oponente) {
        oponente.Lastimar(this.armaEquipada.Fuerza);
    }
}



