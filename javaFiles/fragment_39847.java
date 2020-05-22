@ServerInterceptor
@Provider
public class MyInterceptor implements PreProcessInterceptor, PostProcessInterceptor {

    private static final String ATTRIBUTE_NAME = MyInterceptor.class.getName();

    @Context
    HttpServletRequest servletRequest;

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod resourceMethod) throws Failure, WebApplicationException {
        String url = request.getUri().getRequestUri().toString();
        servletRequest.setAttribute(ATTRIBUTE_NAME, url);
        return null;
    }

    @Override
    public void postProcess(ServerResponse response) {
        String url = servletRequest.getAttribute(ATTRIBUTE_NAME);
        System.out.println(url);
    }
}