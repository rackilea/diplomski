import java.util.*;

class IteratorEnumeration<E> implements Enumeration<E>
{
    private final Iterator<E> iterator;

    public IteratorEnumeration(Iterator<E> iterator)
    {
        this.iterator = iterator;
    }

    public E nextElement() {
        return iterator.next();
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

}


public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>(); 
        Enumeration<String> x = new IteratorEnumeration<String>(set.iterator());
    }
}