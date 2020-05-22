<E> void invokeOnPreviousAndNext(E[] array, E element, Consumer<E> consumer) {
    int index = Arrays.binarySearch(array, element);
    if (index > 0) {
        consumer.accept(array[index - 1]);
    } 
    if (index >= 0 && index < array.length - 1) {
        consumer.accept(array[index + 1]);
    }
}