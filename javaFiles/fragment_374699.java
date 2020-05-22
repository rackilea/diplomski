//removed extends Object. The compiler will add this info for you
public class SortedArray<T extends Comparable<T>> implements Iterable<T> {

    private T[] internalArray;

    private class SortedArrayIterator implements Iterator<T> {
        int currentIndex;
        public SortedArrayIterator() {
            this.currentIndex = 0;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < maxSize;
        }
        @Override
        public T next() {
            return internalArray[currentIndex++];
        }
        @Override
        public void remove() {
            for (int i = currentIndex; i < internalArray.length - 1; i++) {
                internalArray[i] = internalArray[i+1];
            }
        }
    }

    public Iterator<T> iterator() {
        return new SortedArrayIterator();
    }
}