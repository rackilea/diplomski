List<String> list = Arrays.asList(
        "ace", "a", "apple", "cord"
);

Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
});

System.out.println(list);