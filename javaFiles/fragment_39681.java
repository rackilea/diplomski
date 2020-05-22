public static <T> Stream<List<T>> sliding(List<T> list, int size) {
    if(size > list.size()) 
        return Stream.empty();
    return IntStream.range(0, list.size()-size+1)
                    .mapToObj(start -> list.subList(start, start+size));
}