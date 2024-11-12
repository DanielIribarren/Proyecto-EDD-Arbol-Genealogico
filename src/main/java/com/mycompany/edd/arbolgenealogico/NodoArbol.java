package com.mycompany.edd.arbolgenealogico;

public class NodoArbol {

    private  Person tinfo;
    private NodoArbol padre;
    private NodoArbol hijo_Izq;
    private NodoArbol hermano_der;


    public NodoArbol(Person tinfo) {
        this.tinfo = tinfo;
        this.hijo_Izq = null;
        this.padre = null;
        this.hermano_der = null;
    }


    /**
     * @return the tinfo
     */
    public Person getTinfo() {
        return tinfo;
    }



    /**
     * @param tinfo the tinfo to set
     */
    public void setTinfo(Person tinfo) {
        this.tinfo = tinfo;
    }

    /**
     * @return the hijo_Izq
     */
    public NodoArbol getHijo_Izq() {
        return hijo_Izq;
    }

    /**
     * @param hijo_Izq the hijo_Izq to set
     */
    public void setHijo_Izq(NodoArbol hijo_Izq) {
        this.hijo_Izq = hijo_Izq;
    }

    /**
     * @return the hermano_der
     */
    public NodoArbol getHermano_der() {
        return hermano_der;
    }

    /**
     * @param hermano_der the hermano_der to set
     */
    public void setHermano_der(NodoArbol hermano_der) {
        this.hermano_der = hermano_der;
    }

    /**
     * @return the padre
     */
    public NodoArbol getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoArbol padre) {
        this.padre = padre;
    }


    
    
    
    



}
