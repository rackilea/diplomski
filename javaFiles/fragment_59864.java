import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

public class MyCustomCollection<E> extends AbstractCollection<E> {

    private Collection<E> delegate = new ArrayList<E>();

    private void myCustomBehaviour() {
        // TODO: Implement.
    }

    public int size() {
        return this.delegate.size();
    }

    public Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public boolean add(E e) {
        myCustomBehaviour();

        return delegate.add(e);
    }
}