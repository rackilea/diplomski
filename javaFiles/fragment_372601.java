// Java 8
(Config config) -> {
    ConfigPK pk = new ConfigPK();
    pk.setScope(config.getId().getScope());
    pk.setKey(config.getId().getKey());
    return pk;
}

//Java 7
new Converter<Config, ConfigPK>() {
    @Override
    public ConfigPK convert(Config config) {
        ConfigPK pk = new ConfigPK();
        pk.setScope(config.getId().getScope());
        pk.setKey(config.getId().getKey());
        return pk;
    }
}