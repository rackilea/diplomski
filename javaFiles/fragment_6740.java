public class Seii implements Iterable<Integer> {
    private class SeiiIterator implements Iterator<Integer> {
        @Override
        public boolean hasNext() {
            return value <= 42;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            value = 3 * (value / 2);
            return value;
        }
    }


    private int value;

    public Seii(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SeiiIterator();
    }
}