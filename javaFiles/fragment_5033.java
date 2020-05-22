public static <X> X[][] toArray(Collection<? extends Collection<X>> values,
        X[][] result) {

    int i = 0;
    for (Collection<X> row : values)
        result[i] = row.toArray(result[i++]);

    return result;
}