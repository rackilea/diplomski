@Component
public class MyBeanRegistration implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) {
    BeanDefinitionRegistry reg = (BeanDefinitionRegistry) bf;
    reg.registerBeanDefinition("exService",
      BeanDefinitionBuilder
        .rootBeanDefinition(ExecutorService.class)
        .setFactoryMethod("newWorkStealingPool")
        .getBeanDefinition());
  }

}