package Metrovias;

import Metrovias.List;

public class ListE implements List {
    private Object[] data;
    private int window;
    private int size;

    public ListE(){
        data= new Object[20];
        window=-1;
        size=0;
    }

    public void addBefore(Object elem) {
        if (isEmpty()){
            window++;
            data[window]=elem;
        } else{
            if (size==data.length-1){
                resize();
            }
            for (int i =size-1;i>=window;i--){
                data[i+1]=data[i];
            }
            data[window]=elem;
        }
        size++;

    }

    public void addNext(Object elem) {
        if (isEmpty()){
            window++;
            data[window]=elem;
        } else{
            if (size==data.length-1){
                resize();
            }
            for (int i =size-1;i>window;i--){
                data[i+1]=data[i];
            }
            data[window+1]=elem;
            window++;
        }
        size++;
    }

    public void next() {
        if (data[window+1]!=null)
            window++;
    }

    public void before() {
        if (data[window-1]!=null)
            window--;
    }

    public void goTo(int x) {
        if (data[x]!=null)
            window=x;
    }

    public boolean isEmpty() {
        return (data[0]==null);
    }

    public void empty() {
        Object[] aux=new Object[10];
        data=aux;
        window=-1;
    }

    public Object showWindow() {
        return data[window];
    }

    public void delete() {

        for (int i =window;i<size;i++){
            data[i]=data[i+1];
        }
        data[size-1]=null;
        size--;
    }

    public void modify(Object elem) {
        data[window]=elem;
    }

    public int length() {
        return size;
    }

    private void resize(){
        Object[] data2= new Object[data.length+10];
        for (int i =0; i<data.length;i++){
            data2[i]=data[i];
        }
        data=data2;
    }
}
