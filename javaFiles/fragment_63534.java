...
User user;
if((user = validateUser(uid)) == null) {
    requestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED).build());
}

requestContext.setSecurityContext(new SecurityContext() {
    @Override
    public Principal getUserPrincipal() {
        return user;
    }
    @Override
    public boolean isUserInRole(String role) {
        // whatever works here for your environment
    }
    @Override
    public boolean isSecure() {
        return containerRequestContext.getUriInfo().getAbsolutePath().toString().startsWith("https");
    }
    @Override
    public String getAuthenticationScheme() {
        // again, whatever works
    }
});