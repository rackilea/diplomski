class Wrapper {
    private final ActualData data;
    public ActualData getData() {
        return data;
    }
    private final int hash;
    public Wrapper(ActualData data) {
        this.data = data;
        this.has = ... // Compute hash based on data's attr1, 2, and 4
    }
    @Override
    public int hashCode() {
        return hashCode;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wrapper)) return false;
        Wrapper other = (Wrapper)obj;
        return data.getAttr1().equals(other.getAttr1())
            && data.getAttr2().equals(other.getAttr2())
            && data.getAttr4().equals(other.getAttr4());
    }
}