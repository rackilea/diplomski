@Provider
public class RequestParamFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Set<String> validParams = new HashSet<String>();
        Method method = resourceInfo.getResourceMethod();
        for (Annotation[] annos : method.getParameterAnnotations()) {
            for (Annotation anno : annos) {
                if (anno instanceof QueryParam) {
                    validParams.add(((QueryParam) anno).value());
                }
            }
        }
        for (String param : servletRequest.getParameterMap().keySet()) {
            if (!validParams.contains(param)) {
                requestContext.abortWith(Response.status(Status.BAD_REQUEST).build());
            }
        }
    }

}