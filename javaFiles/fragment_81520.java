public class Key {
    private String[] determinants;
    private int hashCode;

    public Key(String... determinants) {
        if (determinants == null || determinants.length == 0) {
            throw new IllegalArgumentException("Please provide at least one value");
        }
        this.determinants = determinants;
        this.hashCode = Objects.hash(determinants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key that = (Key) o;
        return Arrays.equals(determinants, that.determinants);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}