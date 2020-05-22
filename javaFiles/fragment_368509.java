static List<String> sliding(final List<String> strings, final int slidesSize) {
    final int size = strings.size();
    if(size < slidesSize)
        return Collections.emptyList();
    return new AbstractList<String>() {
        @Override
        public String get(int j) {
            final StringBuilder builder = new StringBuilder();
            for (int k = j; k < slidesSize + j; k++) {
                if(k > j) builder.append(' ');
                builder.append(strings.get(k));
            }
            return builder.toString();
        }

        @Override
        public int size() {
            return size - slidesSize+1;
        }
    };
}