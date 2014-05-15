package Metrovias;

public class QueueE {

    private int capacity = 40;
    Object data[];
    int front = 0;
    int rear = -1;
    int size = 0;

    public QueueE(){
        data = new Object[this.capacity];
    }

    public void enqueue(Object element) {

        if (isFull()) {
            increaseCapacity();
        }
        rear++;
        if(rear >= data.length && size != data.length){
            rear = 0;
        }
        data[rear] = element;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No puede desencolar ningún elemento");
        } else {
            front++;
        }
    }

    public boolean isFull(){
      return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object seeFront(){
        return data[front];
    }

    public int length(){
        return data.length;
    }

    private void increaseCapacity(){

        int newCapacity = this.data.length*2;
        Object[] data2 = new Object[newCapacity];
        int tmpFront = front;
        int index = -1;
        while(true){
            data2[++index] = this.data[tmpFront];
            tmpFront++;
            if(tmpFront == this.data.length){
                tmpFront = 0;
            }
            if(size == index+1){
                break;
            }
        }
        this.data = data2;
        this.front = 0;
        this.rear = index;
    }
}



