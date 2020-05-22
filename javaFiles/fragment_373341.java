public static <T extends GeometricShape<T>>
List<T> supersize_list(List<T> list) {
    List<T> result = new ArrayList<>();
    for (T shape : list) {
        result.add(shape.supersize());
    }
    return result;
}