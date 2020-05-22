public class MyMatrix extends Matrix {
    public RowMajorIterator rowMajorIterator() {
        return new MyRowMajorIterator();
    }
    class MyRowMajorIterator extends RowMajorIterator { // inner, named class
        // needs to implement the abstract methods
        public int get() { ... } 
        ...
    }
}