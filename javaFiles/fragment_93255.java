@Bean
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public CurrentUserContext currentUser() {
    return new CurrentUserContextImpl();
}

@Bean
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public ConnectionRepository connectionRepository() {
    String id = currentUser().getId();
    if (id == null) {
        throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
    }
    return usersConnectionRepository().createConnectionRepository(id);
}