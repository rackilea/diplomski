public static void main(String args[]) {
    List<String> list = new ArrayList<String>();
    list.add("a string");

    Iterable<String> iterable = list;
    for (String s : iterable) {
        System.out.println(s);
    }
}