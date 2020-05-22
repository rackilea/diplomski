class HashSetChecker2 implements Checker {
    private final Set<String> set = new HashSet<>(1000);
    { set.addAll(Arrays.asList(VALUES)); }

    @Override
    public boolean contains(String s) {
        return set.contains(s);
    }
}