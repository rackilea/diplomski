public class ConfigurableFactory {
    public <T extends BaseConfigurable> T newConfigurable(Class<T> clazz, String className) throws Exception {
        Class<? extends T> objClass = Class.forName(className)
                .asSubclass(clazz);
        Constructor<? extends T> constructor = objClass.getConstructor();
        return constructor.newInstance();
    }

}