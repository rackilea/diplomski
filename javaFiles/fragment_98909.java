final ResourceConfig rc = new ResourceConfig().packages("com.example");
rc.register(new AbstractBinder() {
    @Override
    protected void configure() {
        bindFactory(HtmlCompressorFactory.class).to(Compressor.class).in(Singleton.class);
    }
});