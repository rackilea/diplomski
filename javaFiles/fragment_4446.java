@RestController
public class MyController {
    @Autowired
    MyService myService;

    //DeferredResult does not send a response until .setResult or setErrorResult is called
    public DeferredResult<String> myService() {
        DeferredResult<String> result = new DeferredResult<>();
        //I'm using Java8 lambda for brevity use an anonymous class instead if using less than java8
        myService.asyncLongOperation((operationResult) -> result.setResult(operationResult))
        return result;
    }
}