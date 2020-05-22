class ClassUsingManagers {
    @Inject
    ClassUsingManagers(
            @Exchange NetworkService exchangeService,
            @Realm NetworkService realmService,
            NetworkServiceHandler handler) {
        handler.actionForService(exchangeService);
        handler.actionForService(realmService);
    }
}