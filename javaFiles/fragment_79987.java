public class Car {
    class Constants {
        public final String MAKE;
        public final String REGISTRATION_NUMBER;
        private Constants(String make, String regNumber) {
            this.MAKE = make;
            this.REGISTRATION_NUMBER = regNumber;
        }
    }

    public final Constants constants;
    public Car(String make, String regNumber) {
        this.constants = new Constants(make, regNumber);
    }
}