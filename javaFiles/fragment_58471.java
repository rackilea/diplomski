@Bean
public BeanFactoryPostProcessor getBeanFactoryPostProcessor() {
  return beanFactory -> {
    for (int i = 0; i < MyBeanType.values().length; i++) {
      beanFactory.registerSingleton(MyBeanType.class.getSimpleName() + i, 
        new MyBean(MyBeanType.values()[i]));
    }
  };
}