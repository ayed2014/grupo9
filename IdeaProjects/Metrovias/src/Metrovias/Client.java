package Metrovias;

public class Client {

    private int entrytime;

    public Client(int entrytime){
        this.entrytime = entrytime;
    }  //Crea un cliente, pidiendo su tiempo de entrada.

    public int getEntrytime(){
        return entrytime;
    }    //Devuelve el tiempo de entrada.
}
