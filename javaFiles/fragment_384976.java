package com.other;

public class ScalaAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter
    implements PriorityOrdered, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    ... Order related stuff...

    public void setBeanFactory(BeanFactory beanFactory) {
        if (beanFactory instanceof ConfigurableListableBeanFactory) {
            this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
        }
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs,     PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        try {
            InjectionMetadata metadata = findScalaMetadata(beanFactory.getBeanDefinition(beanName), bean.getClass());
            metadata.inject(bean, beanName, pvs);
        }
        catch (Throwable ex) {
            throw new BeanCreationException(beanName, "Injection of Scala dependencies failed", ex);
        }
        return pvs;
    }

    private InjectionMetadata findScalaMetadata(BeanDefinition beanDefinition, Class<?> beanClass) throws IntrospectionException {
        LinkedList<InjectionMetadata.InjectedElement> elements = new LinkedList<InjectionMetadata.InjectedElement>();

        Set<PropertyValue> scalaProperties = (Set<PropertyValue>) beanDefinition.getAttribute(ScalaAwarePostProcessorUtils.SCALA_ATTRIBUTES_KEY);
        if (scalaProperties != null) {
            for (PropertyValue pv : scalaProperties) {
                Method setter = ScalaAwarePostProcessorUtils.getScalaSetterMethod(beanClass, pv.getName());
                if (setter != null) {
                    Method getter = ScalaAwarePostProcessorUtils.getScalaGetterMethod(beanClass, pv.getName());
                    PropertyDescriptor pd = new PropertyDescriptor(pv.getName(), getter, setter);
                    elements.add(new ScalaSetterMethodElement(setter, pd));
                }
            }
        }
        return new InjectionMetadata(beanClass, elements);
    }

    private class ScalaSetterMethodElement extends InjectionMetadata.InjectedElement {

        protected ScalaSetterMethodElement(Member member, PropertyDescriptor pd) {
            super(member, pd);
        }

        @Override
        protected Object getResourceToInject(Object target, String requestingBeanName) {
            Method method = (Method) this.member;
            MethodParameter methodParam = new MethodParameter(method, 0);
            DependencyDescriptor dd = new DependencyDescriptor(methodParam, true);
            return beanFactory.resolveDependency(dd, requestingBeanName);
        }
    }
}