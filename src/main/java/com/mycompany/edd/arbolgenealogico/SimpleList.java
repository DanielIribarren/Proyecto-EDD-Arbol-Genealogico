package com.mycompany.edd.arbolgenealogico;

public class SimpleList<T> {

    private Nodo<T> pFirst;
    private Nodo<T> pLast;
    private int size;

    public SimpleList() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.pFirst == null;
    }

    //Anadir al inicio
    public void addStart(T data) {

        Nodo<T> node = new Nodo<>(data);

        if (this.isEmpty()) {
            this.pFirst = node;
            this.pLast = node;
        } else {
            node.setpNext(this.pFirst);
            this.pFirst = node;
        }

        this.size++;

    }

    //Anadir al final
    public void Insert(T data) {

        Nodo<T> node = new Nodo<>(data);
        if (this.isEmpty()) {
            this.pFirst = node;
            this.pLast = node;
        } else {
            this.pLast.setpNext(node);
            this.pLast = node;
        }
        this.size++;
    }

    //recorrer hasta nulo
    public void printList() {
        if (this.isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            try {
                Nodo<T> pAux = this.pFirst;
                System.out.println("Lista:");
                while (pAux != null) {
                    System.out.println(pAux.getData());
                    pAux = pAux.getpNext();
                }
                System.out.println(":");
            } catch (Exception e) {
                System.out.println("error al printear.");
            }
        }
    }

    // devuelve una string que representa la lista
    public String printToString() {
        if (this.isEmpty()) {
            return "//";
        }
        Nodo<T> pAux = this.pFirst;
        //int contador = 0;
        String chain = "";
        while (pAux != null) {
            //System.out.print(contador + ".[ " + pAux.getData() + " ]" + " ->  ");
            chain += pAux.getData() + "->";
            pAux = pAux.getpNext();
            //contador++;
        }
        return chain + "//";
    }


    public T getValueByIndex(int index) {
        Nodo<T> pAux = this.pFirst;
        int count = 0;

        while (pAux != null && count != index) {
            pAux = pAux.getpNext();
            count++;
        }

        if (pAux != null) {
            return pAux.getData();
        } else {
            return null;
        }

    }

    public boolean Search_String(String value) {
        Nodo<T> pAux = this.pFirst;

        while (pAux != null) {
            if (pAux.getData().equals(value)) {
                return true;
            }
            pAux = pAux.getpNext();
        }

        return false;
    }

    public boolean Search_Int(int value) {
        Nodo<T> pAux = this.pFirst;

        while (pAux != null) {
            if (pAux.getData().equals(value)) {
                return true;
            }
            pAux = pAux.getpNext();
        }

        return false;
    }

    public Nodo<T> searchByValue_print(T value) {
        Nodo<T> pAux = this.pFirst;

        while (pAux != null && pAux.getData() != value) {
            pAux = pAux.getpNext();
        }

        if (pAux != null) {
            return pAux;
        } else {
            return null;
        }

    }

    /*
        Metodo para retornar la posicion de un elemento en la lista
     */
    public int indexOf(T valorBuscado) {
        Nodo<T> actual = this.pFirst;
        int index = 0;

        while (actual != null) {
            if (actual.getData().equals(valorBuscado)) {
                return index;
            }

            actual = actual.getpNext();
            index++;
        }

        return -1; // Si no se encuentra el valor, devolvemos -1
    }

    public void deleteFirst() {
        if (this.isEmpty()) {
            System.out.println("Lista vacia.");
        } else {
            pFirst = pFirst.getpNext();
        }
    }

    public void deleteLast() {

        if (this.pFirst == this.pLast) {
            this.pFirst = null;
            this.pLast = null;
            this.size = 0;

        } else {

            Nodo<T> pAux = this.pFirst;

            while (pAux.getpNext().getpNext() != null) {
                pAux = pAux.getpNext();
            }

            pAux.setpNext(null);
            this.pLast = pAux;
        }
    }

    public boolean isValidIndex(int index) {
        return this.getValueByIndex(index) != null;
    }

    public void insertAtIndex(int index, T data) {

        if (!isValidIndex(index)) {
            System.out.println("No existe el indice");
        } else {

            Nodo<T> pAux = this.pFirst;
            int counter = 0;

            while (counter != index) {
                pAux = pAux.getpNext();
                counter++;
            }

            Nodo<T> node = new Nodo<>(data);
            node.setpNext(pAux.getpNext());

            pAux.setpNext(node);
        }
    }

    // elimina un elemento segun su indice en la lista (posicion)
    public void deleteByIndex(int index) {
        if (!this.isEmpty()) {
            if (index == 0) {
                Nodo<T> head = this.pFirst;
                this.pFirst = this.pFirst.getpNext();
                head.setpNext(null);
                this.size--;
            } else if (index < this.getSize()) {
                Nodo<T> pAux = this.pFirst;
                int count = 0;
                while (count < (index - 1)) {
                    pAux = pAux.getpNext();
                    count++;
                }
                Nodo<T> temporal = pAux.getpNext();
                pAux.setpNext(temporal.getpNext());
                temporal.setpNext(null);
                this.size--;
            }
        }
    }

    // ordena la lista
    public void sort() {
        Nodo<Integer> pAux = (Nodo<Integer>) this.pFirst;

        if (pAux == null || pAux.getpNext() == null) {
            return;
        }

        Nodo pPrev = null;

        while (pAux != null) {
            Nodo<Integer> next = pAux.getpNext();
            if (pAux.getData() <= next.getData()) {
                ;
            } else {
                swapIntegers(pAux, next);
            }
            pPrev = pAux;
            pAux = next;
        }

        sort();
    }

    private void swapIntegers(Nodo<Integer> current, Nodo<Integer> next) {
        int aux = current.getData();
        current.setData((Integer) current.getpNext().getData());
        next.setData(aux);

    }

    public void wipeList() {
        this.pFirst = null;
        this.size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size];
        Nodo<T> pAux = this.pFirst;

        for (int i = 0; i < this.size; i++) {
            array[i] = pAux.getData();
            pAux = pAux.getpNext();
        }

        return array;
    }

    public void delete(T data) {

        Nodo<T> currentNode = this.pFirst;
        Nodo<T> previousNode = null;

        while (currentNode != null && !currentNode.getData().equals(data)) {
            previousNode = currentNode;
            currentNode = currentNode.getpNext();
        }

        if (currentNode != null) {
            if (previousNode == null) {
                this.pFirst = currentNode.getpNext();
            } else {
                previousNode.setpNext(currentNode.getpNext());
            }
            this.size--;
        }
    }

    /*
        Getters y Setters
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo<T> pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo<T> getpLast() {
        return pLast;
    }

    public void setpLast(Nodo<T> pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}