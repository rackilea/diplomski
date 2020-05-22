class LineUp {
    private List<Event> events = new ArrayList<>();

    private static final class Pair<U, V> {
        final U first;
        final V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair<U, V> that = (Pair<U, V>) o;
            return Objects.equals(this.first, that.first)
                    && Objects.equals(this.second, that.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.first, this.second);
        }
    }

    // rest of the LineUp class
}