@JmsListener(id = "foo")
...

@Autowired
private JmsListenerEndpointRegistry registry;

...

    registry.getListenerContainer("foo").stop();
...
    registry.getListenerContainer("foo").start();