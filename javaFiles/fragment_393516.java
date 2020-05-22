private void configureConverters() {
    List<ConverterHelper> converters = Engine.getInstance()
            .getRegisteredConverters();
    JacksonConverter jacksonConverter = null;
    for (ConverterHelper converterHelper : converters) {
        System.err.println(converterHelper.getClass());
        if (converterHelper instanceof JacksonConverter) {
            jacksonConverter = (JacksonConverter) converterHelper;
            break;
        }
    }

    if (jacksonConverter != null) {
        Engine.getInstance()
                .getRegisteredConverters().remove(jacksonConverter);
    }
}