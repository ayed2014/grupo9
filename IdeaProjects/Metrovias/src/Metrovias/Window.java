package Metrovias;

public class Window {
        private QueueE clients;
        private double income;
        private int idleTime;
        private int clientsServed;
        private double waitingTime;

        public Window(){
            idleTime=0;
            income=0;
            clientsServed=0;
            waitingTime=0;
            clients= new QueueE();
        }

        public void addClient(int arrivalTime){
            clients.enqueue(new Client(arrivalTime));
        }

        public void tendToClient(int departureTime){
            Client aux=(Client)clients.seeFront();  //Toma al cliente al frente de la cola.
            income+=0.7;                            //Suma a lo recaudado.
            clientsServed++;                        //Suma uno a los clientes atendidos.
            waitingTime+=(departureTime-aux.getEntrytime());       //Cuánto esperó el cliente.
            clients.dequeue();
        }

        public void sumIdleTime(){
            idleTime+=10;
        }

        public double getIncome() {
            return income;
        }

        public int getIdleTime() {
            return idleTime;
        }

        public double getAvgWaitingTime() {
            return (waitingTime)/clientsServed;
        }
        public boolean isEmpty(){
            return clients.isEmpty();
        }
        public int clientsRemaining(){
            return clients.length();
        }
}
