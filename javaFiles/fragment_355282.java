public <T> List<T> getList(List<? super T> numberList, Class<T> clazz) {
    List<T> longList = new ArrayList<T>();
    for(Object n : numberList) {
        longList.add(clazz.cast(n));
    }
    return longList;
}