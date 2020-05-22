@Component(scope = ServiceScope.BUNDLE)
public class MyComponent implements MyService {

    private Bundle usingBundle;

    @Activate
    void activate(ComponentContext context) {
        this.usingBundle = context.getUsingBundle();
    }

    // ... 
}