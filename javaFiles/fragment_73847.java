public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AnnotationMethodHandlerAdapter) {
            AnnotationMethodHandlerAdapter adapter = (AnnotationMethodHandlerAdapter) bean;
            HttpMessageConverter<?>[] converters = adapter.getMessageConverters();

            for (HttpMessageConverter<?> converter : converters) {
                if (converter instanceof MappingJacksonHttpMessageConverter) {
                    initConverter((MappingJacksonHttpMessageConverter) converter);
                }
            }
        } else  if(bean instanceof MappingJacksonHttpMessageConverter){
            initConverter((MappingJacksonHttpMessageConverter) bean);
        }
        return bean;
    }

    private void initConverter(MappingJacksonHttpMessageConverter converter) {
            MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
            final ObjectMapper mapper = // get your mapper from wherever
            jsonConverter.setObjectMapper(mapper);

            /* here you can apply any other configuration you wish*/
     }
}