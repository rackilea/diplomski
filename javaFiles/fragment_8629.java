public class ExampleInterceptor implements HttpRequestResponseInterceptor.RequestInterceptor,
 HttpRequestResponseInterceptor.ResponseInterceptor {

    @Override
    public Request intercept(Request request) throws IOException {
        return request.newBuilder().addHeader("REQUEST_HEADER", "EXAMPLE").build();
    }

    @Override
    public Response intercept(Response response) throws IOException {
        return response.newBuilder().addHeader("RESPONSE_HEADER", "EXAMPLE").build();
    }
}