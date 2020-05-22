if (rolesAllowed.length > 0 && !isAuthenticated(requestContext)) {
    throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
}
...
private static boolean isAuthenticated(final ContainerRequestContext requestContext) {
    return requestContext.getSecurityContext().getUserPrincipal() != null;
}