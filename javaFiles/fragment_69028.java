public class XpathBuilder {

    public Builder builder() {
        return new XpathBuilder.Builder();
    }

    class Builder {

        private final StringBuilder sb;

        Builder() {
            sb = new StringBuilder();
        }

        public Builder child(String name) {
            sb.append("/").append(name);
            return this;
        }

        public Builder down(String name) {
            sb.append("//").append(name);
            return this;
        }

        public String build() {
            return sb.toString();
        }
    }
}