public class Engine{
    private Configuration configuration;

    @Inject 
    public Engine(Configuration configuration) {
        this.configuration = configuration;
    }
    ........
}

public class Car{
    private Engine engine;

    @Inject    
    public Car(Engine engine) {
        this.engine = engine;
    }
}