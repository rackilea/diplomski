final class StringTuple {
    private String[] vals;

    public StringTuple(String... vals) {
        this.vals = vals.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(vals);
    }

    public boolean equals(Object obj) {
        return (obj instanceof StringTuple)
            && Arrays.equals(vals, ((StringTuple) obj).vals);
    }
}