<T extends java.util.Date> T a(T... dates) {
    return b(dates);  // compiles fine
}

<T extends Comparable<? super T>> T b(T... comparables) {
    return comparables[0];
}