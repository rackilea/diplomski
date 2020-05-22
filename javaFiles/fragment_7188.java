@Bean("SessionPool")
PoolFactoryBean sessionPool() {

    PoolFactoryBean sessionPool = new PoolFactoryBean();

    sessionPool.setName("SessionPool");
    sessionPool.setLocators(Arrays.asList(new ConnectionEndpoint("host1", port1),
        new ConnectionEndpoint("host2", port2),
        ...,
        new ConnectionEndpoint("hostN", portN));

    return sessionPool;
}

...