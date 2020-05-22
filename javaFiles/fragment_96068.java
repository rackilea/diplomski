@Bean
    @PostConstruct
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName(String.format("%s-%s", BROKER_PRO, env.getProperty("spring.profiles.active", String.class, "default")));
        config.getGroupConfig().setName(env.getProperty("cache.hazelcast.group.name", String.class, "appName"));
        config.getGroupConfig().setPassword(env.getProperty("cache.hazelcast.group.password", String.class, "appName-password"));
        config.getNetworkConfig().setPortAutoIncrement(env.getProperty("cache.hazelcast.network.portAutoIncrement", Boolean.class, false));
        config.getNetworkConfig().setPortCount(env.getProperty("cache.hazelcast.network.portCount", Integer.class, 1));
        config.getNetworkConfig().setPort(env.getProperty("cache.hazelcast.network.port", Integer.class, 5701));
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(env.getProperty("cache.hazelcast.network.join.multicastConfig.enable", Boolean.class, false));

        TcpIpConfig tcpIpConfig = config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
        String[] ips = env.getProperty("cache.hazelcast.network.join.tcpIpConfig.members", String[].class, new String[]{});
        for (String ip : ips) {
            tcpIpConfig.addMember(ip);
        }
        config.getNetworkConfig().getJoin().setTcpIpConfig(tcpIpConfig);
        config.getMapConfigs().put("default", initializeDefaultMapConfig());
        return HazelcastInstanceFactory.newHazelcastInstance(config);
    }