class TreeSetChecker implements Checker {
    private final Set<String> set = new TreeSet<>(Arrays.asList(VALUES));
    @Override
    public boolean contains(String s) {
        return set.contains(s);
    }
}