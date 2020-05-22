static class JacksonCustomModule extends SimpleModule {
    public JacksonCustomModule() {
        super("JacksonCustomModule", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(IProvider.class, IProviderMixIn.class);
        super.setupModule(context);
    }

    interface IProviderMixIn<T> {
        @JsonValue
        T locate();
    }
}