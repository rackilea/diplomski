public Object[] sorted() {

    Object[] toSort = Arrays.copyOf(getSetArray(),getSize());
    Arrays.sort(toSort);
    return toSort;
}