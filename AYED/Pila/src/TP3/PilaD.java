package TP3;

/**
 * Created with IntelliJ IDEA.
 * User: usu
 * Date: 29/03/14
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class PilaD implements Pila {
    protected Nodo puntero;
    protected Nodo auxiliar;
    private int size=0;

    public void push(Object elemento){
        Nodo aux=new Nodo(elemento);
        aux.sig=puntero;
        puntero=aux;
        auxiliar.sig=puntero;
        size++;
    }

    public void pop(){
        puntero=auxiliar;
        size--;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Object getTop(){
        return puntero.dato;
    }
}
