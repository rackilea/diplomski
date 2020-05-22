public class Matrix<T> implements Iterable<T> {

    T[][] array;
    boolean defaultRowColumnIterator;

    public Matrix(boolean defaultRowColumnIterator) {
        this.defaultRowColumnIterator = defaultRowColumnIterator;
    }

    // other methods and constructors

    public Iterator<T> iteratorRowColumn() {
        return null; // your current implementation
    }

    public Iterator<T> iteratorColumnRow() {
        return null; // your current implementation
    }

    @Override
    public Iterator<T> iterator() {
        return defaultRowColumnIterator ? iteratorRowColumn() : iteratorColumnRow();
    }

}