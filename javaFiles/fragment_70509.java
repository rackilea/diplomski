public class MyPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            WebBindingInitializer wbi = ((RequestMappingHandlerAdapter) bean).getWebBindingInitializer();
            if (wbi == null) {
                wbi = new ConfigurableWebBindingInitializer();
                ((RequestMappingHandlerAdapter) bean).setWebBindingInitializer(wbi);
            }

            if (wbi instanceof ConfigurableWebBindingInitializer) {
                ((ConfigurableWebBindingInitializer) wbi).setPropertyEditorRegistrar(new MyPropertyEditorRegistrar());
            }

        }
    }

}