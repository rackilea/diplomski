class SortManager {
    public <T> void bubbleSort(List<T> list, Comparator<? super T> comp) {
        ...
    }

    public <T> boolean isSorted(List<T> list, Comparator<? super T> comp) {
        ...
        return false;
    }
}