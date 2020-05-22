@Component
public class MyComponent implements SomeService {

    SomeOtherService someOtherService;

    @Reference
    void setSomeOtherService(SomeOtherService sos) {
        someOtherService = sos;
    }

    @Override
    public void someServiceMethod() { 
        someOtherService.doSomethingElse();
    }
}