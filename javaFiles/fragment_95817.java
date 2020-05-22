class TestClass {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList().insertEnd(5).insertEnd(10);
    }
}

abstract class List {
    public abstract List insertEnd(int data);
}

class ArrayList extends List {
    @Override
    public ArrayList insertEnd(int data) {
        // do insertion
        return this;
    }
}

class LinkedList extends List {
    @Override
    public LinkedList insertEnd(int data) {
        // do insertion
        return this;
    }
}