public class HttpRequestResponseInterceptor implements Interceptor {

    public final List<RequestInterceptor> requestInterceptors = new ArrayList<>();
    public final List<ResponseInterceptor> responseInterceptors = new ArrayList<>();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        for (RequestInterceptor interceptor : requestInterceptors) {
            request = interceptor.intercept(request);
        }

        Response response = chain.proceed(request);

        for (ResponseInterceptor interceptor : responseInterceptors) {
            response = interceptor.intercept(response);
        }

        return response;
    }

    public interface RequestInterceptor {
        Request intercept(Request request) throws IOException;
    }

    public interface ResponseInterceptor {
        Response intercept(Response response) throws IOException;
    }
}