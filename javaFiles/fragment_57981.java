class MyComparator<T extends Number & Comparable<T>> 
                                          implements Comparator<ArrayList<T>> {
    @Override
    public int compare(ArrayList<T> a, ArrayList<T> b) {
        return a.get(index).compareTo(b.get(index));
    }
}