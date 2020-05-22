Identifier<Car.IdentifierType, Car> carId =
    new Identifier<Car.IdentifierType, Car>(Car.IdentifierType.LICENSE_PLATE,
        "123 XYZ");

public static class Identifier<T extends Enum, E extends Identifiable<T>> {
    public Identifier(T type, String value) {
        // some code
    }
}