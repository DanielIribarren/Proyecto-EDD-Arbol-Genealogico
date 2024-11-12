package com.mycompany.edd.arbolgenealogico;

public class HashTable<T> {

    private final int TABLE_SIZE = 256;
    private int tableSize;

    private HashEntry<T>[] table;
    private SimpleList <T> entriesList;
    private String originalName;

    public HashTable(){
        this.table = new HashEntry[this.TABLE_SIZE];
        this.entriesList = new SimpleList<>();
        this.updateTableSize();
    }

    public SimpleList<T> getEntriesList(){
        return this.entriesList;
    }

    public String getOriginalName() {
        return originalName;
    }

    public int getTablesize() {
        return tableSize;
    }

    private int hashFunction(int key) {
        return key % getTablesize();
    }

    public boolean KeyIsTaken(String key) {

        int hashedKey = key.toLowerCase().hashCode();
        int hash = Math.abs(hashFunction(hashedKey));

        if (this.table[hash] == null) {
            return false;
        } else {

            HashEntry<T> bucketedEntry = this.table[hash];

            while (bucketedEntry != null) {
                if ((bucketedEntry.getHashedKey() == hashedKey) && (bucketedEntry.getKey().equals(key.toLowerCase()))) {
                    return true;

                }
                bucketedEntry = bucketedEntry.getNext();
            }

            return false;
        }
    }

    private void updateTableSize(){
        this.tableSize = this.table.length;
    }

    public void put(String key, T value) {
        if (!this.KeyIsTaken(key)) {

            int hashedKey = key.toLowerCase().hashCode();
            int hash = hashFunction(hashedKey);
            hash = Math.abs(hash);
            HashEntry<T> newEntry = new HashEntry<>(key.toLowerCase(), hashedKey, value);

            if (table[hash] == null) {

                table[hash] = newEntry;


            } else {
                HashEntry<T> actual = this.table[hash];

                while (actual.getNext() != null) {
                    actual = actual.getNext();
                }

                actual.setNext(newEntry);

            }

            this.entriesList.Insert(value);
        } else {

            System.out.println("La key se encuentra ocupada");

        }
    }

    public T get(String key) {

        int hashedKey = key.toLowerCase().hashCode();
        int hash = Math.abs(hashFunction(hashedKey));
        HashEntry<T> returning = this.table[hash];
        while (returning != null) {

            if ((returning.getHashedKey() == hashedKey) && (returning.getKey().equals(key.toLowerCase()))) {
                return returning.getValue();

            }
            returning = returning.getNext();
        }

        return null;
    }

    public void delete(String key) {

        int hashedKey = key.toLowerCase().hashCode();
        int hash = Math.abs(hashFunction(hashedKey));

        if (this.table[hash] == null) {
            System.out.println("No hay elemento asociado con la key: " + key.toLowerCase() );
        } else {

            //Conseguir el siguiente elemento en la lista de colisiones si existe
            HashEntry<T> bucketedEntry = this.table[hash].getNext();

            //Eliminamos la entry de la lista de entries
            this.entriesList.delete(this.table[hash].getValue());
            this.table[hash] = null;

            //Re introducir toda la lista de clisiones a la hashtable
            while (bucketedEntry != null) {
                this.put(bucketedEntry.getKey(), bucketedEntry.getValue());
                bucketedEntry = bucketedEntry.getNext();
            }

            System.out.println();


        }

    }

    public void clear() {
        this.table = new HashEntry[this.TABLE_SIZE];
        this.entriesList.wipeList();
        this.updateTableSize();
    }

    public void showUsersTable() {
        for (int i = 0; i < this.table.length; i++) {
            HashEntry<T> current = this.table[i];

            while (current != null) {
                System.out.println(current.getKey() + ": " + current.getValue().toString());
                current = current.getNext();
            }
        }
    }

}
