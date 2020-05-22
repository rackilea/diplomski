public enum PostValidation {
    INSTANCE;

    private Map<String, CheckStrategy> registeredStrategies = new HashMap<>();

    public void registerNewStrategy(String propertyName, CheckStrategy strategy) {
        registeredStrategies.put(propertyName, strategy);
    }

    public boolean check(Object toValidate, Properties properties) {
        boolean checkSucceeded = true;
        for (String key : properties.stringPropertyNames()) {
            CheckStrategy strategy = registeredStrategies.get(key);
            if (null != strategy) {
                checkSucceeded = stategy.validate(toValidate, properties.getProperty(key));
            }
            if (!checkSucceeded) {
                LOG.warn(strategy.getClass().getSimpleName() + " failed validation");
                break;
            }
        }
        return checkSucceeded;
    }
}