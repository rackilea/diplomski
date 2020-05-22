public class ConfigReferenceProcessor {

    private ConfigurableFactory configurableFactory = 
        new ConfigurableFactory(); // default instance

    public void setConfigurableFactory(ConfigurableFactory configurableFactory) {
        this.configurableFactory = configurableFactory;
    }

    public <T extends BaseConfigurable> T processConfigReference(
            Class<T> clazz, ConfigReferenceCfg configRef) throws Exception {
        T obj = configurableFactory.newConfigurable(clazz, configRef.getClassName());

        // Some methods to setup and configure the new instance, including:
        obj.loadConfig(configRef.getConfigName());

        return obj;
    }

}