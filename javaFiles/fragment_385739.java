public void loadJndiBeansFromServer(
        @Observes AfterBeanDiscovery beanDiscovery, BeanManager beanManager)
        throws NamingException, ClassNotFoundException, IOException {
    // Due to my inability to navigate in server JNDI naming (a weird issue in Glassfish naming)
    // This props maps interface class to JNDI name for its server-side
    Properties interfacesToNames = extractInterfacesToNames();

    // JNDI properties
    Properties jndiProperties = new Properties();
    Context context = new InitialContext();
    for (Entry<?, ?> entry : interfacesToNames.entrySet()) {
        String interfaceName = entry.getKey().toString();
        Class<?> interfaceClass = Class.forName(interfaceName);
        String jndiName = entry.getValue().toString();
        Bean<?> jndiBean = createJndIBeanFor(beanManager, interfaceClass, jndiName, jndiProperties);
        beanDiscovery.addBean(jndiBean);
    }
}