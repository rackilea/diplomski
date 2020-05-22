@EnableAsync
    public class ServiceClassName {

    /**
    *Method which takes long time to process request. Here Need to add @Asyncn
    */
    @Async("asyncExecutor")
    public void methodName ( DataaType inputParam) {

    //Your business logic goes here

    //If you want to return something, then do link  as below-
    //return CompletableFuture.completedFuture(returnValue);
    }

    }