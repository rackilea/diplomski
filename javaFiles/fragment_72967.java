import org.glassfish.grizzly.http.server.Request;

/**
 * Until the session cookie can be defined in the Grizzly {@link HttpServer},
 * it will be set here.
 * <p>
 * The filter's priority ensures it gets executed before filters with 
 * {@link Priorities#AUTHENTICATION}.
 * 
 * @author hank
 */
@Provider
@Priority(300)  // less than 1000
@PreMatching
public class SessionCookieFilter implements ContainerRequestFilter {

    @Inject
    javax.inject.Provider<Request> requestProvider;

    @Inject
    Config config;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Request request = requestProvider.get();
        request.setSessionCookieName(config.getSessionCookieName());
    }

}