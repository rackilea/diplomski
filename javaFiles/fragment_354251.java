@Component
@Scope("singleton")
public class CarFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    public Car create( Make make, Model model, Year year ) {
        Car car = new Car( make, model, year );

        // this will apply the post processors including ones that might wrap the original bean
        // such as transaction interceptors etc.
        Car carProxy = Car.class.cast(autowireCapableBeanFactory.configureBean(car, "carBean"));
        return carProxy;
    }
}