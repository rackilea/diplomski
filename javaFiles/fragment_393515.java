private void configureConverters() {
    List<ConverterHelper> converters = Engine.getInstance()
            .getRegisteredConverters();
    for (ConverterHelper converterHelper : converters) {
        System.out.println(converterHelper.getClass());
    }
}

@Override
public Restlet createInboundRoot() {
    configureConverters();
    (...)
}