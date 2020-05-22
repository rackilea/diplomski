public T[] getArray(Class<T> clazz) {
    return (T[]) list.toArray((T[])Array.newInstance (clazz, list.size()));
}

....

Integer[] sortedArray = bubbleSort.getArray(Integer.class);