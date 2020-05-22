public class Bike {

    private final String serial;
    private final Wheels wheels;

    @Inject
    public Bike(String serial, Wheels wheels) {
        this.serial = serial;
        this.wheels = wheels;
    }
}

@Module
public final class BikeModule {

    @Provides
    public static Bike provideBike(Wheels wheels) {
        return new Bike("BIK-001", wheels);
    }

    @Provides
    public static Wheels provideWheels() {
        return new Wheels("WLS-027");
    }
}