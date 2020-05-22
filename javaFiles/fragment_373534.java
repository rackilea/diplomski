public Iterator<IFoo> iterator() {
    return new Iterator<IFoo>() {
        private final Iterator<? extends IFoo> iterator = someArrayList.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Number next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    };
}