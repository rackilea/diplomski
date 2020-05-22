@Bean
public EmbeddedServletContainerCustomizer jettyCustomizer() {
    return new EmbeddedServletContainerCustomizer() {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            if (container instanceof JettyEmbeddedServletContainerFactory) {
                ((JettyEmbeddedServletContainerFactory) container)
                        .addServerCustomizers(new JettyServerCustomizer() {

                    @Override
                    public void customize(Server server) {
                        setHandlerMaxHttpPostSize(200 * 1024 * 1024, server.getHandlers());
                    }

                    private void setHandlerMaxHttpPostSize(int maxHttpPostSize,
                            Handler... handlers) {
                        for (Handler handler : handlers) {
                            if (handler instanceof ContextHandler) {
                                ((ContextHandler) handler)
                                        .setMaxFormContentSize(maxHttpPostSize);
                            }
                            else if (handler instanceof HandlerWrapper) {
                                setHandlerMaxHttpPostSize(maxHttpPostSize,
                                        ((HandlerWrapper) handler).getHandler());
                            }
                            else if (handler instanceof HandlerCollection) {
                                setHandlerMaxHttpPostSize(maxHttpPostSize,
                                        ((HandlerCollection) handler).getHandlers());
                            }
                        }
                    }
                });
            }
        }
    };
}