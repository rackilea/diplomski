class Utils<T> {

    List<T> getList(T t, List<List> list) {
        return list.stream().filter(i -> t.getClass().isInstance(i.get(0))).flatMap(List<T>::stream).collect(Collectors.toList());
    }
}