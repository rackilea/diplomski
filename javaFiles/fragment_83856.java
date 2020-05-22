@Bean
public EmbeddedServletContainerCustomizer containerCustomizer() {
    return new EmbeddedServletContainerCustomizer() {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
            if (configurableEmbeddedServletContainer instanceof TomcatEmbeddedServletContainerFactory) {
                ((TomcatEmbeddedServletContainerFactory) configurableEmbeddedServletContainer).addContextCustomizers(
                        new TomcatContextCustomizer() {
                            @Override
                            public void customize(Context context) {
                                context.setReloadable(false);
                            }
                        }
                );
            }
        }
    };
}