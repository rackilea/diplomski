public static <T> T getNext(Spliterator<T> spliterator) {
        List<T> result = new ArrayList<>(1);

        if (spliterator.tryAdvance(result::add)) {
            return result.get(0);
        } else {
            return null;
        }
    }