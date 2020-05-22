public class Car {
    private final boolean hasSunroof;
    private final Color color;
    private final int horsePower;
    private final String modelName;

    private Car(Color color, int horsePower, String modelName, boolean hasSunroof) {
        this.color = color;
        this.horsePower = horsePower;
        this.hasSunroof = hasSunroof;
        this.modelName = modelName;
    }

    public static Builder builder(Color color, int horsePower) {
        return new Builder(color, horsePower);
    }

    public static class Builder {
        private final Color color;
        private final int horsePower;
        private boolean hasSunroof;
        private String modelName = "unknown";

        public Builder(Color color, int horsePower) {
            this.color = color;
            this.horsePower = horsePower;
        }

        public Builder withSunroof() {
            hasSunroof = true;
            return this;
        }

        public Builder modelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Car createCar() {
            return new Car(color, horsePower, modelName, hasSunroof);
        }
    }
}