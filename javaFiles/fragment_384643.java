@Provider
public class HeaderRewriteFilter implements ContainerResponseFilter {
   @Override
   public ContainerResponse filter(ContainerRequest request, ContainerResponse response)  {
     response.setResponse(Response
                .fromResponse(response.getResponse()).header(HttpHeaders.CONTENT_TYPE, "text/plain").build());
             return response;
  }
}