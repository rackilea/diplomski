public List<String> printMessage() {
    String temp = message;
    String[] r = {};
    List<String> list = new ArrayList<String>();
    for (int i = 0; i < temp.length(); i++) {
        r = temp.split("\n");
    }
    list.addAll(Arrays.asList(r));
    return list;
}