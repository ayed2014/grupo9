package TP3;

public class Estacionamiento {

    private PilaEstacionamiento pilaAutos = new PilaEstacionamiento();
    private int recaudacion = 0;

    public void ingresar(String patente){
        if(pilaAutos.length()<50){
          pilaAutos.push(patente);
          recaudacion=recaudacion+5;
        }else System.out.println("El estacionamiento se encuentra lleno");
    }

    public void salida(String buscar){
       PilaEstacionamiento vereda = new PilaEstacionamiento();
       int k=pilaAutos.getPlace(buscar);
       for(int i=pilaAutos.length();i==k+1;i--){
           vereda.push(pilaAutos.popEstacionamiento());
       }

       for(int j=vereda.length();j==0;j--){
           pilaAutos.pushVereda(vereda.popEstacionamiento());
       }
    }

    public int getRecaudacion(){
        return recaudacion;
    }

    public Object getPrimero(){
        return pilaAutos.getTop();
    }
}
