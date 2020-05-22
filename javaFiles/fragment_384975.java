package com.other;

import ...

public class ScalaAwareBeanFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered {

    ... PriorityOrdered related methods...

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String currentName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(currentName);
            processScalaProperties(beanDefinition);
        }
    }

    protected void processScalaProperties(BeanDefinition beanDefinition) {
        String className = beanDefinition.getBeanClassName();
        try {
            Set<PropertyValue> scalaProperties = new HashSet<PropertyValue>();
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
                String scalaSetterName = ScalaAwarePostProcessorUtils.getScalaSetterName(propertyValue.getName());

                BeanInfo beanInfo = getBeanInfo(className);
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
                for (MethodDescriptor md : methodDescriptors) {

                    if (scalaSetterName.equals(md.getName())) {
                        boolean isScalaProperty = true;
                        for (PropertyDescriptor pd : propertyDescriptors) {
                            if (propertyValue.getName().equals(pd.getName())) {
                                isScalaProperty = false;
                            }
                        }
                        if (isScalaProperty) {
                            scalaProperties.add(propertyValue);
                        }
                    }
                }
            }

            if (!scalaProperties.isEmpty()) {
                beanDefinition.setAttribute(ScalaAwarePostProcessorUtils.SCALA_ATTRIBUTES_KEY, scalaProperties);
            }

            for (PropertyValue propertyValue : scalaProperties) {
                beanDefinition.getPropertyValues().removePropertyValue(propertyValue);
            }
        } catch (ClassNotFoundException e) {
        } catch (IntrospectionException e) {
        }
    }

    private BeanInfo getBeanInfo(String className) throws ClassNotFoundException, IntrospectionException {
        Class beanClass = Class.forName(className);
        BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
        cleanIntrospectorCache(beanClass);
        return beanInfo;
    }

    private void cleanIntrospectorCache(Class beanClass) {
        Class classToFlush = beanClass;
        do {
            Introspector.flushFromCaches(classToFlush);
            classToFlush = classToFlush.getSuperclass();
        }
        while (classToFlush != null);
    }
}