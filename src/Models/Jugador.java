
package Models;

public abstract class Jugador {

    protected Arma armaEquipada;
    protected char numeroJugador='0';
    protected int vida=100;
    protected String Tipo_jugador="";
    public char getChar()
    {
        return numeroJugador;
    }
    public void setChar(char c)
    {
        this.numeroJugador=c; 
    }
    public abstract void EquiparArma(Arma arma);
    public abstract void Curar(int valorCura) ;

    public boolean isVivo() {
        return vida>=0;
    }

    public void ImprimirJugador()
    {
        for(int i=0;i<=24;i++)
        {
            System.out.print('*');
        }
        System.out.println("");
        System.out.print('*');
        System.out.print("Jugador [" +this.getChar()+"]");
        System.out.print('*');
        System.out.print('*');
        System.out.print("Vida: " + vida);
        System.out.print('*');
        System.out.print("");
        System.out.print('*');
        System.out.print("Daño: " + armaEquipada.Fuerza);
        System.out.print('*');
        System.out.println("");
        for(int i=0;i<=49;i++)
        {
            System.out.print('*');
        }
        System.out.println("");
    }

    abstract public void Jugar(Mapa m,Jugador oponente) ;
    abstract public void JugarPlayer1(Mapa m,Jugador oponente) ;
    abstract public void JugarPlayer2(Mapa m,Jugador oponente) ;
    abstract public void JugarPlayer3(Mapa m,Jugador oponente) ;

    void Lastimar(int Fuerza) {
        this.vida-=Fuerza;
    }
    
    public Arma ArmaEquipada(){
        return armaEquipada;
    }
    
    public void setTipo_jugador(String Tipo_jugador){
        this.Tipo_jugador=Tipo_jugador;
    }
    
    public String getTipo_Jugador(){
        return Tipo_jugador;
    }
}
