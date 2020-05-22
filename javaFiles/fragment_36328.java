public static <T> T total(List<T> list, MonoidOps<T> ops) {
    T sum = ops.id();
    for (T e : list) {
        sum = ops.op(e, sum);
    }
    return sum;
}