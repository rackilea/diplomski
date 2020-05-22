public class IteratorWrapper<T> implements Enumeration<T> {
    Iterator<T> iterator;

    public IteratorWrapper(Iterator<T> iterator){
        this.iterator = iterator;
    }

    public boolean hasMoreElements(){
        return iterator.hasNext();
    }

    public T nextElement(){
        return iterator.next();
    }
}