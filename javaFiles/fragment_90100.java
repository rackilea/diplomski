public class OfyService {
    static {
        ObjectifyService.register(Employee.class);
        ObjectifyService.register(Vehicle.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}