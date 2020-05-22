class List {
    private int size;
    private Customer[] data;
    private final static int DEFAULT_CAPACITY = 10; 

    public List() {
        size = 0;
        data = new Customer[DEFAULT_CAPACITY];
    }

    public void append(List another) {
        int anotherSize = another.size;
        for (int i = anotherSize - 1; i >= 0; --i) {
            if (size < data.length) {
                data[size++] = another.data[i];
                another.data[i] = null;
                another.size--;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
}