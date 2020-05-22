class MyClass {
    byte b;
    int i;
    String s;
}

class MyClassList {
    int size = 0;
    int capacity;
    byte[] bytes;
    int[] ints;
    String[] strings;

    MyClassList(int capacity) {
        this.capacity = capacity;
    }

    public void add(MyClass myClass) {
        if (size == capacity) resize();
        bytes[size] = myClass.b;
        ints[size] = myClass.i;
        strings[size] = myClass.s;
        size++;
    }

    public void get(MyClass myClass, int index) {
        if (index > size) throw new IndexOutOfBoundsException();
        myClass.b = bytes[index]; 
        myClass.i = ints[index];
        myClass.s = strings[index];
    }
}