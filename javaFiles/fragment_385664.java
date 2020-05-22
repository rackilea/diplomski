public List<String> createStrings() {
    List<String> list = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
        list.add("foo" + i);
    }
    return list;
}