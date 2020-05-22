public static <T, C extends Collection<LinkedList<T>>> C rewrap (Collection<ArrayList<T>> in, Supplier<C> collectionFactory) {

    C out = collectionFactory.get ();

    for (ArrayList<T> list : in) {
      out.add (new LinkedList<T> (list));
    }

    return out;
}