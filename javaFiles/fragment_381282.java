public class MyObjectReader implements Iterable<String> {
    private BufferedReader rdr;

    public MyObjectReader(BufferedReader rdr) {
        this.rdr = rdr;
    }

    @Override
    Iterator<String> iterator() {
        return new BufferedReaderIterator();
    }
    . . .

    private class BufferedReaderIterator implements Iterator<String> {
        String cachedLine;

        @Override
        public String next() {
            String result = cachedLine == null ? rdr.readLine() : cachedLine;
            cachedLine = null;
            if (result == null) {
                throw new NoSuchElementException();
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            if (cachedLine == null) {
                cachedLine = rdr.readLine();
            }
            return cachedLine != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}