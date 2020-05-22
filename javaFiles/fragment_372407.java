public <R> ExtendedList<R> castToUnchecked() {
    return delegate.stream().map(item -> (R) item).collect(ExtendedList.toList());
}

public static <R, U extends R> ExtendedList<R> castTo(ExtendedList<U> l) {
    return l.<R>castToUnchecked();
}