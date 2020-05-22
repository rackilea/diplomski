@Component
public class AController {
    private final AsyncOperator async;
    public AController(AsyncOperator async){
        this.async = async;
    }

    public String aMethod(String body){
        // here it will return right after call
        this.async.launchAsync(body);

        return "Returned right away !!";
    }
}