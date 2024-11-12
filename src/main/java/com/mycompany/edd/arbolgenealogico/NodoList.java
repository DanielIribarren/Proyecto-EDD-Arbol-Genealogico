package com.mycompany.edd.arbolgenealogico;

public class NodoList<T> {


    private T data;
    private NodoList pNext;

    public NodoList(T data){

        this.data = data;
        this.pNext = null;

    }
    // Sobrecarga de metodos: Dos metodos con el mismo nombre pueden ser distintos si tienen argumentos diferentes
    public NodoList(T data, NodoList<T> pNext){
        this.data = data;
        this.pNext = pNext;

    }

    // Insert code: Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodoList getpNext() {
        return pNext;
    }

    public void setpNext(NodoList<T> pNext) {
        this.pNext = pNext;
    }

}
