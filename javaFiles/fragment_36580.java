public class GMOFacts extends NutritionFacts {

    private final boolean hasGMO;

    public static class Builder extends NutritionFacts.Builder<Builder> {

        private boolean hasGMO = false;

        public Builder() {}

        public Builder GMO(boolean val) {
            hasGMO = val;
            return this;
        }

        public GMOFacts build() { return new GMOFacts(this); }
    }

    protected GMOFacts(Builder builder) {
        super(builder);
        hasGMO = builder.hasGMO;
    }
}