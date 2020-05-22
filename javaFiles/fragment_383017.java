public class MyFactoryBean implements BeanFactoryAware {
  private BeanFactory beanFactory;

  public void setBeanFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  public void someMethod() {
    MyBean myBean = beanFactory.getBean("myBean", MyBean.class);
    ...
  }
}