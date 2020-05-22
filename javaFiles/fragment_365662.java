public class NGram {
    private String   token;
    private String[] previousToken; // could also be List<String>
    public NGram(String ... allTokens) {
        if (allTokens.length == 0)
            throw new IllegalArgumentException("At least one token is required");
        for (String s : allTokens)
            if (s == null)
                throw new NullPointerException();
        this.token = allTokens[allTokens.length - 1];
        this.previousToken = Arrays.copyOfRange(allTokens, 0, allTokens.length - 1);
    }
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (String s : this.previousToken)
            buf.append(s).append(' ');
        return buf.append(this.token).toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        NGram that = (NGram) obj;
        return this.token.equals(that.token) &&
               Arrays.equals(this.previousToken, that.previousToken);
    }
    @Override
    public int hashCode() {
        return this.token.hashCode() + 31 * Arrays.hashCode(this.previousToken);
    }
}