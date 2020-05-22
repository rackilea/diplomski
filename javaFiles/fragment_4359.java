@Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Google google(final ConnectionRepository repository) {
        final Connection<Google> connection = repository.findPrimaryConnection(Google.class);
        if (connection == null)
            log.debug("Google connection is null");
        else
            log.debug("google connected");
        return connection != null ? connection.getApi() : null;
    }