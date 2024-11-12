package com.mycompany.edd.arbolgenealogico;

public class Nodo<T> {


    private T data;
    private Nodo pNext;

    public Nodo(T data){

        this.data = data;
        this.pNext = null;

    }
    // Sobrecarga de metodos: Dos metodos con el mismo nombre pueden ser distintos si tienen argumentos diferentes
    public Nodo(T data, Nodo<T> pNext){
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

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo<T> pNext) {
        this.pNext = pNext;
    }

}
