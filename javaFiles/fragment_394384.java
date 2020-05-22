register(new AbstractBinder(){
    @Override
    public void configure() {
        bindFactory(ObjectMapperFactory.class)
            .to(ObjectMapper.class).in(Singleton.class);
    }
});