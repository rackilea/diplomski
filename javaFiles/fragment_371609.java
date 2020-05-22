@PreMatching
public static class SimpleAuthFilter implements ContainerRequestFilter {

    private static final Map<String, User> userStore = new ConcurrentHashMap<>();

    static {
        userStore.put("peeskillet", new User("peeskillet", Arrays.asList("ADMIN", "USER")));
        userStore.put("paulski", new User("paulski", Arrays.asList("USER")));
    }

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        final String authHeader = request.getHeaderString("Authorization");
        final String username = authHeader.split("=")[1];
        final User user = userStore.get(username);
        if (user == null) {
            throw new NotAuthorizedException("No good.");
        }
        request.setSecurityContext(new SimpleSecurityContext(user));
    }
}