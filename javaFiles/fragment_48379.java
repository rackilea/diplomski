@Component
public class VehicleFactory {

    @Autowired
    FooAStrategy fooAStrategy;

    @Autowired
    FooBStrategy fooBStrategy;

    boolean buildTruck = true; //get from external system parameter instead

    public  <T> Vehicle<T> getObject(Class<?> clazz) throws Exception {
        if (clazz.equals(FooA.class)) {
            if (buildTruck) {
                return (Vehicle<T>) new Truck<FooA>(fooAStrategy);
            }
            return (Vehicle<T>) new Car<FooA>(fooAStrategy);
        } 
        return (Vehicle<T>) new Car<FooB>(fooBStrategy);
    }