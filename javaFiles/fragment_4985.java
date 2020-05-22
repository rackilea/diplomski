public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp) {
    if (comp==null)
        return (T)max((Collection<SelfComparable>) (Collection) coll);

Iterator<? extends T> i = coll.iterator();
T candidate = i.next();

    while (i.hasNext()) {
    T next = i.next();
    if (comp.compare(next, candidate) > 0)
    candidate = next;
}
return candidate;
}