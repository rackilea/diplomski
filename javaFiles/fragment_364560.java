@Bean(name = IntegrationContextUtils.ARGUMENT_RESOLVER_MESSAGE_CONVERTER_BEAN_NAME)
public static ConfigurableCompositeMessageConverter configurableCompositeMessageConverter(
        @Qualifier(IntegrationUtils.INTEGRATION_CONVERSION_SERVICE_BEAN_NAME) ConversionService conversionService) {
    return new ConfigurableCompositeMessageConverter(
            Collections.singleton(new GenericMessageConverter(conversionService)));
}