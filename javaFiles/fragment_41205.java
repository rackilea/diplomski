private void combine(Stream<String> a, Stream<String> b, List<String> c, BinaryOperator<String> op) {
    Iterator<String> i1 = a.iterator();
    Iterator<String> i2 = b.iterator();
    Iterable<String> i = () -> new Iterator<String>() {
        public boolean hasNext() {
            return i1.hasNext() && i2.hasNext();
        }
        public String next() {
            return op.apply(i1.next(), i2.next());
        }
    };
    c = StreamSupport.stream(i.spliterator(), false).collect(Collectors.toList());
}