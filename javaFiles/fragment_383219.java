import java.util.List;

import javafx.collections.ModifiableObservableListBase;

public class NonEmptyObservableList<E> extends ModifiableObservableListBase<E> {

    private final List<E> source ;

    public NonEmptyObservableList(List<E> source) {
        if (source.isEmpty()) {
            throw new IllegalStateException("List cannot be empty");
        }
        this.source = source ;
    }


    @Override
    public E get(int index) {
        return source.get(index);
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    protected void doAdd(int index, E element) {
        source.add(index, element);
    }

    @Override
    protected E doSet(int index, E element) {
        return source.set(index, element);
    }

    @Override
    protected E doRemove(int index) {
        if (size() <= 1) {
            throw new IllegalStateException("List cannot be empty");
        }
        return source.remove(index);
    }

}