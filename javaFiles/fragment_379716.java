public class VehicleSpecifications {
    public static Specification<Vehicle> withCity(Long city) {
        if (city == null) {
            return null;
        } else {
            // Specification using Java 8 lambdas
            return (root, query, cb) -> cb.equal(root.get("city"), city);
        }
    }

    // TODO: Implement withModel, withVehicleType, withBrand, ...
}