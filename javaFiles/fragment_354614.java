public void add(int a, int b) {
    Set<Integer> values = connection.get(a);
    if (values==null) {
        values = new HashSet<Integer>();
        connection.put(a, values);
    }
    values.add(b);
}