public List<E> cons(E a, List<E> l) {
    List<E> cons_list = new List<E>();

    if (a instanceof Atom)    {
        cons_list.list.add(a);
    }

    cons_list.list.addAll(l.list);

    return cons_list;
}