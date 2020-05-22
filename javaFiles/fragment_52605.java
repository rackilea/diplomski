public void addSingle(E item) {
    LinkedList<E> singleList = new LinkedList<E>();
    singleList.add(item);

    list.add(singleList);
}

public void addPair(E first, E second) {
    LinkedList<E> pairList = new LinkedList<E>();
    pairList.add(first);
    pairList.add(second);

    list.add(pairList);
}

public void addTriple(E first, E second, E third) {
    LinkedList<E> tripleList = new LinkedList<E>();
    tripleList.add(first);
    tripleList.add(second);
    tripleList.add(third);

    list.add(tripleList);
}

private List<List<E>> list = new LinkedList<List<E>>();