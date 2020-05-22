@Component
public class RestInterceptor implements ClientHttpRequestInterceptor {

 @Override
 public ClientHttpResponse intercept(HttpRequest request, byte[] body,
  ClientHttpRequestExecution execution) throws IOException {
  traceRequest(request, body);
  ClientHttpResponse response = execution.execute(request, body);
  traceResponse(response);
  return response;
 }

 private void traceRequest(HttpRequest request, byte[] body) throws IOException {
   //track request here
 }


 private void traceResponse(ClientHttpResponse response) throws IOException {
    //track response here
 }

}