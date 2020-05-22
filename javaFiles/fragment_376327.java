public static void main(String ... params) {
    Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            install(new FactoryModuleBuilder().build(IElement1Factory.class));
        }
    });

    MetamodelImpl model = injector.getInstance(MetamodelImpl.class);
    Element element = model.getElement("Initialize-Me");
    System.out.println(element);
}