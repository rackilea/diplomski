@Component
public class CustomRetryListener  extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, 
    RetryCallback<T, E> callback,
        Throwable throwable) {
        //recover from throwable
    }

}