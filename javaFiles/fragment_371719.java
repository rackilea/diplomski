requestContext.setSecurityContext(new SecurityContext() {

    @Override
    public Principal getUserPrincipal() {

        return new Principal() {

            @Override
            public String getName() {
                return username;
            }
        };
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
});