.... 

@Override
protected void configure() {
    /*
    Adds binding for @CurrentUser.
    By default, factories are being injected with PerLookup scope.
    */
    bindFactory(CurrentUserSupplier.class)
            .to(User.class)
            .proxy(true)
            .proxyForSameScope(false)
            .in(RequestScoped.class);
    bind(CurrentUserResolver.class)
            .to(new GenericType<InjectionResolver<CurrentUser>>(){})
            .in(Singleton.class);
}
....