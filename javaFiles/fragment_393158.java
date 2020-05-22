@Component
public class MyAsyncService {

    @Async
    public CompletableFuture<ResultClass> myAsyncMethod(String params){
        //do some heavy tasks here
        return CompletableFuture.completedFuture(instanceOfResultClass);
    }
}