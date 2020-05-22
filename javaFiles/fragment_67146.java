public E car(List<E> l) {

    if (l.list.get(0) instanceof Atom)
        // Your `E` is an Atom, you know this when coming then
        // Your list contains E's, so you don't have to cast it
        return l.list.get(0);
    else
        // Here you need the double cast, because you don't try
        // the actual class: it may be anything.
        return (E)(List<E>) l.list.get(0);
}