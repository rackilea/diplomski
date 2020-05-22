public boolean validate(Stream<Whatever> stream) {
    boolean parallel = stream.isParallel();
    Spliterator<Whatever> sp = stream.spliterator();
    if(sp.getExactSizeIfKnown() == 0) return false;
    Stream.Builder<Whatever> b = Stream.builder();
    if(!sp.tryAdvance(b)) return false;
    return Stream.concat(b.build(), StreamSupport.stream(sp, parallel))
        .allMatch(Whatever::someCheck);
}