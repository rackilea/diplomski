class MyIntSet implements IntSet {
    private TreeSet<Integer> set;
    public MyIntSet(Set<Integer> s) {
        set = new TreeSet<>(s);
    }
    @Override Set<Integer> getSet() { return set; }
}