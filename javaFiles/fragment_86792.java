@Configuration
public class AppConfig implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        for (int i = 0; i < 3; i++) {
            System.out.println("register my bean: " + i);
            beanFactory.registerSingleton("bean-" + i, new MyBean("MyBean-" + i));
        }
    }
}