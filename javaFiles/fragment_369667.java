@Component
public class FooBarBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(@NonNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
        /*
        String[] fooBeans = beanFactory.getBeanNamesForAnnotation(Foo.class);
        BeanDefinition bean = beanFactory.getBeanDefinition(...);

        /* do your processing here ... */
    }
}