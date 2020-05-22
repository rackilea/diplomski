@Autowired
private JmsListenerEndpointRegistry registry;

...

    registry.start(); // starts all containers
    // or
    registry.getListenerContainer(myContainerId).start();