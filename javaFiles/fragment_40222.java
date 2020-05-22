// Authentication filter contains code which performs authentication
// and possibly authorization based on the request
@Provider
public class AuthFilter implements ContainerRequestFilter {
    private final AuthInfo authInfo;

    @Inject
    AuthFilter(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // You can check request contents here and even abort the request completely
        // Fill authInfo with the data you need
        Principal principal = ...;  // Ask some other service possibly
        authInfo.setPrincipal(principal);
    }
}

@Path("hello")
public class HelloResource {
    private final AuthInfo authInfo;

    @Inject
    HelloResource(AuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    @GET
    @Produces("application/json")
    public String hello() {
        // authInfo here will be pre-filled with the principal, assuming
        // you didn't abort the request in the filter
        return authInfo.getPrincipal().getUsername();
    }
}

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthFilter.class);
        bind(HelloResource.class);
        bind(AuthInfo.class).in(RequestScoped.class);
    }
}