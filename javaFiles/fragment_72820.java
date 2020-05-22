interface IOFunction<T,R> {
    R apply(T in) throws IOException;
}
static <T,R> Function<T,R> wrap(IOFunction<T,R> f) {
    return t-> { try { return f.apply(t); }
      catch(IOException ex) { throw new UncheckedIOException(ex); }
    };
}