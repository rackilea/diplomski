public static void main(String... args) {
    SourceHandler source = new SparkHandler(inputSource);

    ServiceLocator locator = ServiceLocatorUtilities.bind(new AbstractBinder() {
        @Override
        protected void configure() {
            bind(source).to(SourceHandler.class);
        }
    });

    ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/rest/*");
    serHol.setInitParameter(ServletProperties.SERVICE_LOCATOR, locator);
}