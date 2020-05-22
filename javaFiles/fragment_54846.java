List<Object[]> doSomething(Integer arg1, ...) {
    List rawList = ...
    @SuppressWarnings("unchecked")
    List<Object[]> cookedList = (List<Object[]>)rawList;
    return cookedList;
}