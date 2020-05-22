private <T> Iterable<T> iterate(final Iterator<T> i){
    return new Iterable<T>() {
        @Override
        public Iterator<T> iterator() {
            return i;
        }
    };
}