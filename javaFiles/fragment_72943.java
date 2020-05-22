public static void main(String[] args) throws ClassNotFoundException {
    int i = 0;
    StringBuilder sb = new StringBuilder("a");
    for (i = 0; i < 20; i++) {
        sb.append(sb.toString());
    }
    System.err.println(sb.length());
    i = 0;
    Set<String> strings = new HashSet<String>();
    while (true) {
        strings.add(sb.append(i++).toString().intern());
        System.err.println(i);
    }
}