@Component
public class MyComponent implements SomeService {

    @Reference
    SomeOtherService someOtherService;

    @Override
    public void someServiceMethod() { 
        someOtherService.doSomethingElse();
    }
}