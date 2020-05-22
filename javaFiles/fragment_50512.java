public class Configuration {

    private static Map<Long, Configuration> configurations = new HashMap<>();

    private long key;
    private long value;

    public static Configuration getInstanse(long key, boolean... configs) {
        if (configurations.containsKey(key)) {
            return configurations.get(key).setConfigs(configs);
        }
        Configuration configuration = new Configuration(key, configs);
        configurations.put(key, configuration);
        return configuration;
    }

    // Max number of configs.length is 64
    private Configuration(long key, boolean... configs) {
        this.key = key;
        setConfigs(configs);
    }

    private Configuration setConfigs(boolean[] configs) {
        this.value = 0L;
        boolean config;
        for (int i = 0; i < configs.length; i++) {
            config = configs[i];
            this.value = this.value | (config ? (1L << i) : 0L);
        }
    }

    public long getKey() {
        return key;
    }

    public boolean getConfig(int place) {
        return (value & (1L << place)) == (1L << place);
    }
}