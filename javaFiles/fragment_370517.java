private static List<List<String>> x = new ArrayList<List<String>>();
static {
    for (int i = 0 ; i != 10 ; i++) {
        x.add(new ArrayList<String>(20));
    }
}