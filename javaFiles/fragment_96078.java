public static <E> void removeRepeats(Iterable<E> iterable) {
    E prevValue = null;
    for (Iterator<E> iter = iterable.iterator(); iter.hasNext(); ) {
        E value = iter.next();
        if (value.equals(prevValue))
            iter.remove();
        else
            prevValue = value;
    }
}