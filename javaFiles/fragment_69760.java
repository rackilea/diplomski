public final class PurifiedTitle implements Comparable<PurifiedTitle> {
    private final String original;
    private final String purified;
    public PurifiedTitle(String title) {
        this.original = title;
        // Purified string has only lowercase letters and digits,
        // with no accents on the letters
        this.purified = Normalizer.normalize(title, Normalizer.Form.NFD)
                .replaceAll("\\P{Alnum}+", "")
                .toLowerCase(Locale.US);
    }
    @Override
    public String toString() {
        return this.original;
    }
    @Override
    public int compareTo(PurifiedTitle that) {
        return this.purified.compareTo(that.purified);
    }
    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof PurifiedTitle))
            return false;
        PurifiedTitle that = (PurifiedTitle) obj;
        return this.purified.equals(that.purified);
    }
    @Override
    public int hashCode() {
        return this.purified.hashCode();
    }
}