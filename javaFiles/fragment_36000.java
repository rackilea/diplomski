class MyImmutableClass {
    private ImmutableList<Integer> data;
    public MyImmutableClass(List<Integer> data) {
        this.data = Lists.immutable.withAll(data);
    }
    public ListIterable<Integer> getData() {
        return data;
    }
}