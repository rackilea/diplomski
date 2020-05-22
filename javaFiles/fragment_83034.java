/**
 * Post-processor to be used if any modifications to the handler adapter need to be made
 * 
 * @author bozho
 *
 */
public class AnnotationHandlerMappingPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String arg1)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String arg1)
            throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
            List<HandlerMethodArgumentResolver> resolvers = adapter.getCustomArgumentResolvers();
            if (resolvers == null) {
                resolvers = Lists.newArrayList();
            }
            resolvers.add(new AnnotationServletModelAttributeResolver(false));
            adapter.setCustomArgumentResolvers(resolvers);
        }

        return bean;
    }

}