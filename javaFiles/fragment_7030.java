public interface MyList<E> extends MyCollection<E>, List<E> {
    @Override default boolean isEmpty() {
        return MyCollection.super.isEmpty();
    }

    @Override default Iterator<E> iterator(){
        return listIterator();
    }
    ...
}