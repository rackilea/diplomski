public Iterator<E> iterator() {
    return new Iterator<E>() {
        private int index = 0;

        public boolean hasNext() {
            return index < ArrayTree.this.size();
        }

        public E next() {
           if (!hasNext()) {
               return new NoSuchElementException();
           }
           return ArrayTree.this.tree[index++];
        }

        public void remove() {
            return new OperationNotSupported();
        }
    }
}