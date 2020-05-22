public final class Vehicle {

    private final String type;
    private final int wheels;

    private Vehicle(Builder builder) {
        this.type = builder.type;
        this.wheels = builder.wheels;
    }

    public static Builder carBuilder() {
        return new Builder("car");
    }

    public static Builder truckBuilder() {
        return new Builder("truck");
    }

    public static class Builder {
        private final String type;
        private int wheels;

        private Builder(String type) {
            this.type = type;
        }

        public Builder addWheels(int wheels){
            this.wheels = wheels;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }               
    }

    public static void main(String[] args) {
        Vehicle car = Vehicle.carBuilder().addWheels(4).build();
        Vehicle truck = Vehicle.truckBuilder().addWheels(10).build();
    }
}