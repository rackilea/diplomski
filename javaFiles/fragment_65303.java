public static class MyLettuceConnectionFactory extends LettuceConnectionFactory {

    private final MyMasterSlaveConfiguration configuration;

    public MyLettuceConnectionFactory(MyMasterSlaveConfiguration standaloneConfig,
            LettuceClientConfiguration clientConfig) {
        super(standaloneConfig, clientConfig);
        this.configuration = standaloneConfig;
    }

    @Override
    protected LettuceConnectionProvider doCreateConnectionProvider(AbstractRedisClient client, RedisCodec<?, ?> codec) {
        return new ElasticacheConnectionProvider((RedisClient) client, codec, getClientConfiguration().getReadFrom(),
                this.configuration);
    }
}

static class MyMasterSlaveConfiguration extends RedisStandaloneConfiguration {

    private final List<RedisURI> endpoints;

    public MyMasterSlaveConfiguration(List<RedisURI> endpoints) {
        this.endpoints = endpoints;
    }

    public List<RedisURI> getEndpoints() {
        return endpoints;
    }
}