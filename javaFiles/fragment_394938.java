private Type[] arrayList;
private int currentSize;

@Override
public Iterator<Type> iterator() {
    Iterator<Type> it = new Iterator<Type>() {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < currentSize && arrayList[currentIndex] != null;
        }

        @Override
        public Type next() {
            return arrayList[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    };
    return it;
}