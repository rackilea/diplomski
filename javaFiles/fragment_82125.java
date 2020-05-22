<T> List<T> readFile(String file) {
    List<T> list = new ArrayList<T>();
    // ...
    return list;
}

public void foo() {
    List<Integer> l1 = readFile("l1");
    List<String> l2 = readFile("l2");
}