Spliterator.OfInt sp = new Spliterators.AbstractIntSpliterator(1000L,
    Spliterator.ORDERED | Spliterator.IMMUTABLE | Spliterator.NONNULL) {
        public boolean tryAdvance(IntConsumer action) {
            int ch;
            try { ch=reader.read(); }
            catch(IOException ex) { throw new UncheckedIOException(ex); }
            if(ch<0) return false;
            action.accept(ch);
            return true;
        }
    };
StreamSupport.intStream(sp, false)
// now you have your stream and you can operate on it:
…