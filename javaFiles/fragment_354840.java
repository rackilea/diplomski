static <T> void diff(Iterator<T> lefts, Iterator<T> rights, Comparator<T> comparator,
        Consumer<T> onlyLeft, Consumer<T> equals, Consumer<T> onlyRight) {
    while (lefts.hasNext() && rights.hasNext()) {
        recur(lefts.next(), rights.next(), lefts, rights, comparator, onlyLeft, equals, onlyRight);
    }
    if (!lefts.hasNext()) {
        rights.forEachRemaining(onlyRight);
    }
    if (!rights.hasNext()) {
        lefts.forEachRemaining(onlyLeft);
    }
}

static <T> void recur(T left, T right, Iterator<T> lefts, Iterator<T> rights,
        Comparator<T> comparator, Consumer<T> onlyLeft, Consumer<T> equals,
        Consumer<T> onlyRight) {
    if (comparator.compare(left, right) == 0) {
        equals.accept(left);
    } else if (comparator.compare(left, right) < 0) {
        onlyLeft.accept(left);
        if (lefts.hasNext()) {
            recur(lefts.next(), right, lefts, rights, comparator, onlyLeft, equals, onlyRight);
        } else {
            onlyRight.accept(right);
        }
    } else {
        onlyRight.accept(right);
        if (rights.hasNext()) {
            recur(left, rights.next(), lefts, rights, comparator, onlyLeft, equals, onlyRight);
        } else {
            onlyLeft.accept(left);
        }
    }
}