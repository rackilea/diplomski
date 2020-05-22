public static Stream<String> chunks(Path path, int chunkSize) throws IOException {
    return chunks(path, chunkSize, StandardCharsets.UTF_8);
}
public static Stream<String> chunks(Path path, int chunkSize, Charset cs)
throws IOException {
    Objects.requireNonNull(path);
    Objects.requireNonNull(cs);
    if(chunkSize<=0) throw new IllegalArgumentException();

    CharBuffer cb = CharBuffer.allocate(chunkSize);
    BufferedReader r = Files.newBufferedReader(path, cs);
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<String>(
            Files.size(path)/chunkSize, Spliterator.ORDERED|Spliterator.NONNULL) {
            @Override public boolean tryAdvance(Consumer<? super String> action) {
                try { do {} while(cb.hasRemaining() && r.read(cb)>0); }
                catch (IOException ex) { throw new UncheckedIOException(ex); }
                if(cb.position()==0) return false;
                action.accept(cb.flip().toString());
                return true;
            }
    }, false).onClose(() -> {
        try { r.close(); } catch(IOException ex) { throw new UncheckedIOException(ex); }
    });
}