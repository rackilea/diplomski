class Pojo {

    private ImmutableList<Integer> ints;

    public ImmutableList<Integer> getInts() {
        return ints;
    }

    public void setInts(ImmutableList<Integer> ints) {
        this.ints = ints;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "ints=" + ints + " " + ints.getClass() + '}';
    }
}