private List<?> list;

public Constructor(list) {
    this.list = Collections.synchronizedList(list);
}

public void loopingMethod() {
    list.foreach(currentElement -> {// Do stuff...});
}

public void deletingMethod(int index) {
    list.remove(index); // This assumes the index is within bound
}