public void createRequestBeanFromSetterMethod(String containingBeanName, BeanDefinition containingBean, Method method, BeanDefinitionRegistry registry)
  {
    String fieldName = ReflectionUtil.getFieldNameFromSetter(method.getName());
    String singletonBeanName = containingBeanName+"_"+fieldName;
    String requestBeanName = "scopedTarget."+singletonBeanName;

    BeanDefinition requestBean = createAnonymousRequestBean(ReflectionUtil.getFieldTypeFromSetter(method), containingBean);

    RootBeanDefinition singletonBean = new RootBeanDefinition();
    singletonBean.setBeanClass(ScopedProxyFactoryBean.class);
    singletonBean.getPropertyValues().addPropertyValue("targetBeanName", requestBeanName);

    registry.registerBeanDefinition(singletonBeanName, singletonBean);
    registry.registerBeanDefinition(requestBeanName, requestBean);

    beanDefinition.getPropertyValues().addPropertyValue(fieldName, new RuntimeBeanReference(singletonBeanName));

  }

  private BeanDefinition createAnonymousRequestBean(Class<?> beanType, BeanDefinition parentBean)
  {
    BeanDefinition newBean = null;
    if (parentBean != null)
    {
      newBean = new GenericBeanDefinition(parentBean);
    }
    else
    {
      newBean = new GenericBeanDefinition();
    }

    if (beanType != null)
    {
      newBean.setBeanClassName(beanType.getName());
    }

    newBean.setScope("request");
    newBean.setAutowireCandidate(false);

    // This would have come from the Proxy annotation...could add support for different values
    String proxyValue = "org.springframework.aop.framework.autoproxy.AutoProxyUtils.preserveTargetClass";
    BeanMetadataAttribute attr = new BeanMetadataAttribute(proxyValue, true);
    newBean.setAttribute(proxyValue, attr);

    return newBean;
  }