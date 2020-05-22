public class HashTable<T> {

    private Object[] table;  
    private static final int SIZE = 50;

    public HashTable(){
        this.table = new Object[SIZE];
        for(int i = 0; i < SIZE; i++)
            this.table[i] = new GenericLinkedList();
    }
}