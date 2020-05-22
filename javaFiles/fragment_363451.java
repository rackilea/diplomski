register(new AbstractBinder() {
    @Override
    public void configure() {
        bindAsContract(MyExceptionMapperFactory.class)
                .to(ExceptionMappers.class)
                .in(Singleton.class);
    }
})