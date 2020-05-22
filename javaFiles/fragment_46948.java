public class MyCustomBdrpp implements BeanDefinitionRegistryPostProcessor {

  private ApplicationContext context;

  private MyCostomBdrpp(ApplicationContext context) {
    this.context = context;
  }

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    //foo
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    //bar
  }
}