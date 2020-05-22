private static class SimpleSecurityContext implements SecurityContext {

    private final User user;

    SimpleSecurityContext(User user) {
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return new Principal() {
            @Override
            public String getName() {
                return user.getUsername();
            }
        };
    }

    @Override
    public boolean isUserInRole(String role) {
        return user.getRoles().contains(role);
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public String getAuthenticationScheme() {
        return "simple";
    }
}