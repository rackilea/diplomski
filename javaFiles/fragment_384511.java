enum MyStringComparator implements Comparator<String> {
    INSTANCE;

    @Override
    public int compare(String s1, String s2) {
        int n1 = Integer.parseInt(s1.split("\\.")[2]);
        int n2 = Integer.parseInt(s2.split("\\.")[2]);
        return Integer.compare(n1, n2);
    }
}