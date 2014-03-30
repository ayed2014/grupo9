package TP3;

public class PilaE implements Pila {

    public Object[]data=new Object[50];
    protected int top=0;

    public void push(Object element){
        if(top<data.length){
            data[top]=element;
        }else{
            resize();
            data[top]=element;
        }
        top++;
    }

    public void pop(){
        top--;
    }

    public boolean isEmpty(){
        return top==0;
    }

    public Object getTop(){
        return data[top-1];
    }

    protected Object[] resize(){
        Object[]data2=new Object[data.length+50];
        for(int i=0;i==data.length;i++){
            data2[i]=data[i];
        }
        data=data2;
        return data2;

    }
}
