public class MultiResourceBundle extends ResourceBundle {

    protected static final Control CONTROL = new MultiResourceBundleControl();
    private Properties properties;

    public MultiResourceBundle(String baseName) {
        setParent(ResourceBundle.getBundle(baseName, CONTROL));
    }

    protected MultiResourceBundle(Properties properties) {
        this.properties = properties;
    }

    @Override
    protected Object handleGetObject(String key) {
        return properties != null ? properties.get(key) : parent.getObject(key);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Enumeration<String> getKeys() {
        return properties != null ? (Enumeration<String>) properties.propertyNames() : parent.getKeys();
    }

    protected static class MultiResourceBundleControl extends Control {
        @Override
        public ResourceBundle newBundle(
            String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException
        {
            Properties properties = load(baseName, loader);
            String include = properties.getProperty("include");
            if (include != null) {
                for (String includeBaseName : include.split("\\s*,\\s*")) {
                    properties.putAll(load(includeBaseName, loader));
                }
            }
            return new MultiResourceBundle(properties);
        }

        private Properties load(String baseName, ClassLoader loader) throws IOException {
            Properties properties = new Properties();
            properties.load(loader.getResourceAsStream(baseName + ".properties"));
            return properties;
        }
    }

}