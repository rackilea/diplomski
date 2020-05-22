// this is the constructor that 'context' is using, and refresh is defaulted to true
public ClassPathXmlApplicationContext(String... configLocations) throws BeansException {
    this(configLocations, true, null);
}

// the constructor that both others are calling
public ClassPathXmlApplicationContext(String[] configLocations, boolean refresh, ApplicationContext parent)
        throws BeansException {
    super(parent);
    setConfigLocations(configLocations);
    if (refresh) {
        // you don't want to refresh until your parent context is set
        refresh();
    }
}

// the constructor I think you should use, it will set the parent first and then refresh
public ClassPathXmlApplicationContext(String[] configLocations, ApplicationContext parent) throws BeansException {
    this(configLocations, true, parent);
}