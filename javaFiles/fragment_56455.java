environment.jersey().register(new TokenResource(configuration.getJwsSecretKey()));
environment.jersey().register(new HelloResource());
environment.jersey().register(RolesAllowedDynamicFeature.class);
environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
environment.jersey()
    .register(
        new AuthDynamicFeature(
            new ChainedAuthFilter<>(
                Arrays
                    .asList(
                        new JWTCredentialAuthFilter.Builder<User>()
                            .setAuthenticator(
                                new JWTAuthenticator(configuration.getJwsSecretKey()))
                            .setPrefix("Bearer").setAuthorizer(new UserAuthorizer())
                            .buildAuthFilter(),
                        new JWTDefaultCredentialAuthFilter.Builder<User>()
                            .setAuthenticator(new JWTDefaultAuthenticator())
                            .setAuthorizer(new UserAuthorizer()).setRealm("SUPER SECRET STUFF")
                            .buildAuthFilter()))));