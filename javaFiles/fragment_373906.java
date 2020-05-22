class Permutator<T> implements Iterable<List<T>> {

    final List<T> items;
    final int homMuch;

    Permutator(List<T> items, int homMuch) {
        this.items = items;
        this.homMuch = homMuch;
    }

    @Override
    public Iterator<List<T>> iterator() {
        return new Iterator<List<T>>() {
            static final int OVERFLOW = -1;
            final int[] permutation = new int[homMuch];
            final int max = items.size();

            @Override
            public boolean hasNext() {
                for (int item : permutation) {
                    if (item == OVERFLOW) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public List<T> next() {
                ArrayList<T> result = new ArrayList<>(permutation.length);
                for (int index : permutation) {
                    result.add(items.get(index));
                }

                inc(permutation, 0);           // generate next permutation

                return result;
            }

            private void inc(int[] indexes, int index) {
                if (index >= indexes.length) {
                    for (int i = 0; i < indexes.length; i++) {
                        indexes[i] = OVERFLOW;
                    }
                    return;
                }
                int nextValue = indexes[index] + 1;
                if (nextValue < max) {
                    indexes[index] = nextValue;
                } else {
                    indexes[index] = 0;
                    inc(indexes, index + 1);
                }
            }

        };
    }
}