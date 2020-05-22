public class RunnableRequest<T extends ApiResponse> implements Runnable {
    private Class<T> apiResponse;
    private Callback<T> callback;

    public RunnableRequest(Class<T> apiResponse, Callback<T> callback) {
        this.callback = callback;
        this.apiResponse = apiResponse;            
    }

    @Override
    public void run() {
        String exampleResponse = "{\"result\":\"Success\",\"message\":\"Hello World\",\"error\":\"0\"}";            
        callback.apiRequestProcessFinished(new Gson().fromJson(exampleResponse, apiResponse));

    }
}

public interface Callback<T extends ApiResponse> {       
    public void apiRequestProcessFinished(T apiResponse);
}

static <T extends ApiResponse> RunnableRequest<T> createRequestRunnable(Class<T> apiResponse,
        Callback<T> callback) {
    return new RunnableRequest<T>(apiResponse, callback);
}