public class MyMatrix extends Matrix {
    public RowMajorIterator rowMajorIterator() {
        return new RowMajorIterator() { // anonymous class
            // needs to implement the abstract methods
            public int get() { ... } 
            ...
        }
    }
}