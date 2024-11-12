package com.mycompany.edd.arbolgenealogico;

public class Arbol {
    
    private NodoArbol pRoot;
    private String NombreCasa;

    public Arbol(String NombreCasa) {
        this.pRoot = null;
        this.NombreCasa = NombreCasa;
    }

    /**
     * @return the pRoot
     */
    public NodoArbol getpRoot() {
        return pRoot;
    }

    /**
     * @param pRoot the pRoot to set
     */
    public void setpRoot(NodoArbol pRoot) {
        this.pRoot = pRoot;
    }


    public NodoArbol insertar(Person person, NodoArbol padre){
        NodoArbol nuevoNodo = new NodoArbol(person);
        nuevoNodo.setPadre(padre);

        if(padre == null){
            //Si no tiene padre, el nuevo nodo es la raiz;
            this.pRoot = nuevoNodo;

        }else{

            if(padre.getHijo_Izq() == null){
                padre.setHijo_Izq(nuevoNodo);

            }else{

                NodoArbol current = padre.getHijo_Izq();
                while (padre.getHermano_der() != null){
                    current = current.getHermano_der();

                }
                current.getHermano_der().setHermano_der(nuevoNodo);
            }
        }
        return nuevoNodo;
    }

}
