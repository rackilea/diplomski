@Bean
public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
    return (tomcat) -> tomcat.addConnectorCustomizers((connector) -> {
        if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
            AbstractHttp11Protocol<?> protocolHandler = (AbstractHttp11Protocol<?>) connector
                    .getProtocolHandler();
            protocolHandler.setDisableUploadTimeout(false);
            protocolHandler.setConnectionUploadTimeout(5000);
        }
    });
}