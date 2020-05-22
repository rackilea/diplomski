@Provider
public class TestFilter implements ContainerRequestFilter {

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        SecurityContext oldSec = request.getSecurityContext();

        final String username = "foobar";
        final String email = "email@email.com";
        final User user = new User(username, email);

        request.setSecurityContext(new MySecurityContext(user, oldSec.isSecure()));
        return request;
    }

    private static class MySecurityContext implements SecurityContext {

        private final boolean isSecure;
        private final User user;

        public MySecurityContext(User user, boolean isSecure) {
            this.isSecure = isSecure;
            this.user = user;
        }

        @Override
        public Principal getUserPrincipal() {
            return this.user;
        }

        @Override
        public boolean isUserInRole(String s) {
            return false;
        }

        @Override
        public boolean isSecure() {
            return this.isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return null;
        }
    }

    public static class User implements Principal {

        private final String email;
        private final String username;

        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }

        @Override
        public String getName() {
            return null;
        }

        public String getEmail() {
            return this.email;
        }
    }
}