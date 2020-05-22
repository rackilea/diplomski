public static <T extends Addable<T>> product (int times, T factor) {
    T result = factor;
    while(n > 1) {
        result = sum(result, factor);
    }
    return result;
}