class Pojo {

    private List<Integer> ints;

    public List<Integer> getInts() {
        return ints;
    }

    public void setInts(List<Integer> ints) {
        this.ints = ints;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "ints=" + ints + " " + ints.getClass() + '}';
    }
}