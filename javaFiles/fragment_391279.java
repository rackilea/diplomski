public AppConfig extends ResourceConfig {
    public AppConfig() {
        register(new AbstractBinder() {
            @Override
            public void configure() {
                bindFactory(LocalFactory.class)
                    .to(Locale.class).in(RequestScoped.class);
            }
        });
    }
}