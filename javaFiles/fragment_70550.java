public static void main(String args[]) {
       List<Object> objects = List.of(1, 2, "SomeString", List.of(3, 4, 5, 6),
            7, List.of("a", "b", "c"),
            List.of(8, List.of(9, List.of(10))));
       List<Object> list = objects.stream().flatMap(c -> getNestedStream(c)).collect(Collectors.toList());
}

public static Stream<Object> getNestedStream(Object obj) {
    if(obj instanceof Collection){
        return ((Collection)obj).stream().flatMap((coll) -> getNestedStream(coll));
    }
    return Stream.of(obj);
}