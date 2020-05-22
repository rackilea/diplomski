import java.util.*;

public class VehicleGarageSample {

    interface Vehicle { }

    static class Bus implements Vehicle {}

    static class Car implements Vehicle {}

    static class Motorcycle implements Vehicle {}

    //////////////////////////////////////////////////////////////

    static class Garage {

        private static Map<Character, Class<? extends Vehicle>> vehicleTypeReg = new HashMap<>();

        public static void registerVehicleType(Character c, Class<? extends Vehicle> type) {
            vehicleTypeReg.put(c, type);
        }

        //////////////////////////////////////////////////////////////

        private Map<Class<? extends Vehicle>, List<Vehicle>> vehicleSlots = new HashMap<>();

        private Map<Class<? extends Vehicle>, Integer> vehicleLimits = new HashMap<>();

        public Garage(String chars) {
            for (char c : chars.toCharArray()) {

                Class<? extends Vehicle> vType = vehicleTypeReg.get(c);
                if (vType == null) {
                    throw new IllegalArgumentException("Unknown vehicle type '" + c + "'");
                }

                // Initialize vehicleSlots
                vehicleSlots.computeIfAbsent(vType, k -> new ArrayList<>());

                // Initialize vehicleLimits
                if (vehicleLimits.containsKey(vType)) {
                    vehicleLimits.put(vType, vehicleLimits.get(vType) + 1);
                } else {
                    vehicleLimits.put(vType, 1);
                }
            }
        }

        public void parkVehicle(Vehicle v) {
            Integer limit = vehicleLimits.getOrDefault(v.getClass(), 0);
            int parked = vehicleSlots.getOrDefault(v.getClass(), Collections.emptyList()).size();

            if (parked >= limit) {
                throw new IllegalStateException("No more space for " + v.getClass().getSimpleName());
            }

            vehicleSlots.get(v.getClass()).add(v);
        }
    }

    //////////////////////////////////////////////////////////////

    // How to use Garage
    public static void main(String[] args) {

        Garage.registerVehicleType('B', Bus.class);
        Garage.registerVehicleType('C', Car.class);
        Garage.registerVehicleType('M', Motorcycle.class);
        // add more if you want

        Garage garage = new Garage("MMBC");
        garage.parkVehicle(new Motorcycle());
        garage.parkVehicle(new Motorcycle());
        garage.parkVehicle(new Bus());
        garage.parkVehicle(new Car());

        garage.parkVehicle(new Car());  // this fails
    }
}