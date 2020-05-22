@Provider
@Component // because I'm using spring boot
public class GetMessageBodyFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        if (requestContext.getEntity() instanceof Map && requestContext.getMethod().equals(HttpMethod.GET)) {
            UriBuilder uriBuilder = UriBuilder.fromUri(requestContext.getUri());
            Map allParam = (Map)requestContext.getEntity();
            for (Object key : allParam.keySet()) {
                uriBuilder.queryParam(key.toString(), allParam.get(key));
            }
            requestContext.setUri(uriBuilder.build());
            requestContext.setEntity(null);
        }
    }
}