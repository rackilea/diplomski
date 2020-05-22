public class IntArrayDemo {
    private static final int DEFAULT_SIZE = 10;
    private int [] values;

    public IntArrayDemo() {
        this(DEFAULT_SIZE);
    }

    public IntArrayDemo(int size) { 
        if (size < 0) throw new IllegalArgumentException("size cannot be negative");
        this.values = new int[size];
    }
}