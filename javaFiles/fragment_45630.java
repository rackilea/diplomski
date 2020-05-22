public class UniversalComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == o2)
            return 0;
        int cmp = compare(o1.getClass(), o2.getClass());
        // if the classes are the same, and they are Comparable.
        if (cmp == 0 && o1 instanceof Comparable)
            cmp = ((Comparable) o1).compareTo(o2);
        // otherwise use the built in toString/hashCode/identityHashCode
        if (cmp == 0)
            cmp = Integer.compare(o1.toString(), o2.toString());
        if (cmp == 0)
            cmp = Integer.compare(o1.hashCode(), o2.hashCode());
        if (cmp == 0)
            cmp = Integer.compare(System.identityHashCode(o1), System.identityHashCode(o2));
        // otherwise generate a unique id for them
        if (cmp == 0)
            cmp = Integer.compare(uniqueId(o1), uniqueId(o2));
        return cmp;
    }

    final Map<Object, Integer>  uniqueId = new IdentityHashMap<>();
    private synchronized int uniqueId(Object o) {
        return uniqueId.computeIfAbsent(o, k -> uniqueId.size());
    }
}