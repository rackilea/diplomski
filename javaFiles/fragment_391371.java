public static class AuthorizationInflector
        implements Inflector<ContainerRequestContext, Response> {

    private final String[] rolesAllowed;
    private final Inflector<ContainerRequestContext, Response> delegate;

    protected AuthorizationInflector(String[] rolesAllowed,
                                     Inflector<ContainerRequestContext, Response> delegate) {
        this.rolesAllowed = (rolesAllowed != null) ? rolesAllowed : new String[] {};
        this.delegate = delegate;
    }

    @Override
    public Response apply(ContainerRequestContext context) {
        applyAuthorization(context);

        return this.delegate.apply(context);
    }


    private void applyAuthorization(ContainerRequestContext requestContext) {
        if (rolesAllowed.length > 0 && !isAuthenticated(requestContext)) {
            throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
        }

        for (final String role : rolesAllowed) {
            if (requestContext.getSecurityContext().isUserInRole(role)) {
               return;
           }
        }
        throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
    }

    private static boolean isAuthenticated(final ContainerRequestContext requestContext) {
        return requestContext.getSecurityContext().getUserPrincipal() != null;
    }
}