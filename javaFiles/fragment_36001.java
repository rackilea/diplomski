class MyImmutableClass {
    private MutableList<Integer> data;
    public MyImmutableClass(List<Integer> data) {
        this.data = Lists.mutable.withAll(data);
    }
    public ListIterable<Integer> getData() {
        return data.asUnmodifiable();
    }
}