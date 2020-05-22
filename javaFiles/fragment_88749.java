class ClassUsingManagers {
    @Inject
    ClassUsingManagers(
            Set<NetworkService> services,
            NetworkServiceHandler handler) {
        for(NetworkService service : services)
            handler.actionForService(service);
    }
}