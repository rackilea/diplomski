public class MyAuthorizer extends Authorizer {
    private String[] getRoles = new String[] { "read"};
    private String[] putRoles = new String[] { "update"};
    private String[] deleteRoles = new String[] { "delete"};

    private boolean hasRoles(String[] expectedRoles) {
        List<Role> roles = request.getClientInfo().getRoles();
        for (String expectedRole : expectedRoles) {
            for (Role role : roles) {
                if (role.getName().equals(expectedRole)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkRoles(String[] roles) {
        if (!hasRole(roles)) {
            throw new ResourceException(
               Status.CLIENT_ERROR_FORBIDDEN);
        }
    }

    public boolean authorize(Request request, Response response) {
        if (!request.getClientInfo().isAuthenticated()) {
            throw new ResourceException(
               Status.CLIENT_ERROR_FORBIDDEN);
        }

        if ("GET".equals(request.getMethod().getName())) {
            checkRoles(getRoles);
        } else if ("PUT".equals(request.getMethod().getName())) {
            checkRoles(putRoles);
        } else if ("DELETE".equals(request.getMethod().getName())) {
            checkRoles(deleteRoles);
        }

        return false;
    }
}