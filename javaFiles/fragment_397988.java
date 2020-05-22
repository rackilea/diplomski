@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NonAuthenticated {}

@NonAuthenticated
// Perform before normal authorization filter
@Priority(Priorities.AUTHORIZATION - 1)
public class NonAuthenticatedCheckFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request) {
        final SerurityContext context = request.getSecurityContext();
        if (context.getUserPrincipal() != null) {
            throw new ForbiddenException();
        }
    }
}

@POST
@NonAuthenticated
public void register(CreateAccountJson account) { }

// register the Dw
environment.jersey().register(NonAuthenticatedCheckFilter.class);