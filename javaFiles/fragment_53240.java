public class MyArrayList<T> extends ArrayList<T> {

    public Enumeration<T> enumerator() {
        return new MyEnumeratorAdapter(this.iterator());
    }
}