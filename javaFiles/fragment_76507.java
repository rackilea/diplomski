public class RestTemplateInterceptor implements ClientHttpRequestInterceptor{

@Override
public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

    String token = RequestContext.getContext().getToken();

    request.getHeaders().add(RequestContext.REQUEST_HEADER_NAME, token);

    return execution.execute(request, body);

}

}