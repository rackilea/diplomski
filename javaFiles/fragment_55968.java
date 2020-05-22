@Provider
public final class GeneralAccessHandler implements ContainerRequestFilter, ContainerResponseFilter {

    /** The incoming request we obtained. */
    @Context
    private final HttpServletRequest mHttpServletRequest;

    /** Some useful informations about the accesspoint in our service. */
    @Context
    private final UriInfo mUriInfo;

    @Override
    public ContainerRequest filter(final ContainerRequest request) {
        if (null != mHttpServletRequest) {
            System.out.println("Method: " + mHttpServletRequest.getMethod());
            System.out.println("Session: " + mHttpServletRequest.getSession().getId());
            System.out.println("User Agent: " + mHttpServletRequest.getHeader("user-agent"));
            final String addr = mHttpServletRequest.getRemoteAddr();
            final int port = mHttpServletRequest.getRemotePort();
            System.out.println("Client: " + addr + ":" + port);
        }
        if (null != mUriInfo) {
            System.out.println("URI: " + mUriInfo.getRequestUri().getPath());
        }
        return request;
    }

    @Override
    public ContainerResponse filter(final ContainerRequest pReq, final ContainerResponse pResp) {
        System.out.println("Outgoing Response")
        return pResp;
    }

}