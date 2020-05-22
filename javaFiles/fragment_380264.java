@Bean
public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
    return (factory) -> {
        ((TomcatEmbeddedServletContainerFactory) factory)
                .addConnectorCustomizers((connector) -> {
            ((AbstractHttp11Protocol<?>) connector.getProtocolHandler())
                    .setUseServerCipherSuitesOrder(Boolean.toString(true));
        });
    };
}