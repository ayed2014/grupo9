package Metrovias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sistema {

        private ListE windows;
        private int windowAmount;

        public Sistema(){

            windows=new ListE();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
            boolean continuar=true;
            try {
                while(continuar){
                    System.out.print("Ingrese el numero de ventanillas: ");
                    windowAmount= Integer.parseInt(br.readLine()) ;
                    if (windowAmount>=3 && windowAmount<=10){
                        continuar=false;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i=0;i<windowAmount;i++){
                windows.addNext(new Window());
            }
        }

        public void simulate(){

            for (int time=0; time<57600; time+=10){
                for (int i =0; i <5; i++){
                    int randomWindow=(int) (Math.random()*(windowAmount));
                    windows.goTo(randomWindow);                      //Busca una ventana al azar
                    Window aux= (Window)windows.showWindow();         //Muestra la ventana.
                    aux.addClient(time);                                 //Agrega un cliente a la ventana.
                }
                for (int j=0;j<windowAmount;j++){
                    int random= (int) ((Math.random())*10+1);
                    windows.goTo(j);
                    Window aux=(Window) windows.showWindow();
                    if (aux.clientsRemaining()>0){
                        if (random<=3) {
                            aux.tendToClient(time);}
                        else aux.sumIdleTime();
                    } else aux.sumIdleTime();
                }
            }
            for (int k=0;k<windowAmount;k++) {
                windows.goTo(k);
                Window aux= (Window) windows.showWindow();
                while(!aux.isEmpty()){
                    aux.tendToClient(57599);
                }
            }

            for(int k=0;k<windowAmount;k++){
                windows.goTo(k);
                Window aux= (Window) windows.showWindow();
                System.out.println("Ventanilla "+(k+1)+": ");
                System.out.println("-Tiempo medio de espera por cliente: " + (aux.getAvgWaitingTime()/60)+" minutos.");
                System.out.println("-Total recaudado en pesos: " + (aux.getIncome()));
                System.out.println("-Tiempo ocioso de la ventanilla: " + (aux.getIdleTime()/60)+" minutos.");
            }
        }
}