@Service
public class ServiceClassA {
    private FooA fooA;
    private FooB fooB;
    private Vehicle<FooA> vehicle;

    @Autowired
    public ServiceClassA(
            FooA fooA, FooB fooB, 
            CarFactory vehicleFactory
            ) throws Exception {
        this.fooA = fooA;
        this.fooB = fooB;
        this.vehicle = vehicleFactory.<FooA>getObject(FooA.class);
    }
}