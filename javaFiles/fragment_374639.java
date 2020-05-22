NavigableSet<String> tree = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
tree.addAll(Arrays.asList("he", "help", "helpless", "hope"));
String[] queries = {"h", "he", "hea"};
for (String query : queries) {
    String higher = tree.ceiling(query);
    System.out.println(query + ": " + higher.startsWith(query));
}