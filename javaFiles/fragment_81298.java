@Stateless
public class SampleService {

    @Inject
    @Security
    private Logger securityLogger;

    public void doSomething() {
        securityLogger.log("I did something!");
    }

}