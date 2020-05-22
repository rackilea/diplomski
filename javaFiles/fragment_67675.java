ConfigurableListableBeanFactory clbf =
        (ConfigurableListableBeanFactory)beanFactory;
  String[] beanNames = clbf.getBeanNamesForType(myType);
  for (String beanName : beanNames) {
     BeanDefinition bd = clbf.getBeanDefinition(beanName);
     if (bd.isPrimary()) {
        ...
     }
  }