private <Type> Bean<Type> createJndIBeanFor(BeanManager beanManager, Class<Type> interfaceClass,
        String jndiName, Properties p) {
    AnnotatedType<Type> annotatedType = beanManager
            .createAnnotatedType(interfaceClass);
    // Creating injection target in a classical way will fail, as interfaceClass is the interface of an EJB
    JndiBean<Type> beanToAdd = new JndiBean<Type>(interfaceClass, jndiName, p);
    return beanToAdd;
}