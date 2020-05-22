@Override
protected Application configure() {
    return new ResourceConfig() {
        {
            register(MockSuccessTokenService.class);
            ...
        }
    };
}