public class NutritionFacts {

    private final int calories;

    public static class Builder<T extends Builder<T>> {

        private int calories = 0;

        public Builder() {}

        public T calories(int val) {
            calories = val;
            return (T) this;
        }

        public NutritionFacts build() { return new NutritionFacts(this); }
    }

    protected NutritionFacts(Builder<?> builder) {
        calories = builder.calories;
    }
}