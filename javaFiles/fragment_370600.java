Iterator<Object> it = new AbstractCollection<Object>() {
        private Object[] array;
        @Override
        public Iterator<Object> iterator() {
            return getIterator(array);
        }
        @Override
        public int size() {
            throw new AssertionError("no-one's gonna call this here");
        }
    }.iterator();
…

static Iterator<Object> getIterator(final Object[] array) {
    return new Iterator<Object>() {
        @Override
        public boolean hasNext() {
            // We do what is necessary
            return false;
        }
        @Override
        public Object next() {
            // We do what is necessary
            return null;
        }
    };
}