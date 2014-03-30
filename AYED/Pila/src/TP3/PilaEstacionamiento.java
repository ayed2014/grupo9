package TP3;

public class PilaEstacionamiento extends PilaE {

    public int length(){
        return data.length;
    }

    public int getPlace(Object search){
        int k=0;
        for(int i=0;i==data.length;i++){
            if(data[i].equals(search)){
                k=i;
            }
        }
        return k;
    }

    public Object popEstacionamiento(){
        top--;
        return data[top+1];
    }

    public void pushVereda(Object element){
        data[top-1]=element;
        top++;
    }
}
