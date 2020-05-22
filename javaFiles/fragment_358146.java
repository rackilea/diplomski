class MyIntSet implements IntSet {
    private TreeSet<Integer> set;
    private int lower, upper;
    public MyIntSet(int lower, int upper) {
        set = new TreeSet<>();
        for(int i = lower; i <= upper; i++) { set.add(i) };
        this.lower = lower;
        this.upper = upper;
    }
    @Override Set<Integer> getSet() { return set; }
    @Override boolean setContains(int x) { return x >= lower && x <= upper; }
}