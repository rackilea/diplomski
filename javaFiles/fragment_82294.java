public static <T> Optional<T> getNext(Spliterator<T> spliterator) {
        final List<T> result = new ArrayList<>(1);

        if (spliterator.tryAdvance(result::add)) {
            return Optional.of(result.get(0));
        } else {
            return Optional.empty();
        }
    }