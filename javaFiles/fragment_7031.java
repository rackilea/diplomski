public interface MyList<E> extends MyCollection<E>, List<E> {
    @Override boolean isEmpty();

    @Override default Iterator<E> iterator(){
        return listIterator();
    }
    ...
}