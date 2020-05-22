@Override
public boolean isTemplateAvailable(String view, Environment environment, ClassLoader classLoader,
        ResourceLoader resourceLoader) {
    if (ClassUtils.isPresent("com.mitchellbosecke.pebble.PebbleEngine", classLoader)) {
        String prefix = environment.getProperty("pebble.prefix", PebbleProperties.DEFAULT_PREFIX);
        String suffix = environment.getProperty("pebble.suffix", PebbleProperties.DEFAULT_SUFFIX);
        return resourceLoader.getResource(ResourceLoader.CLASSPATH_URL_PREFIX + prefix + view + suffix).exists();
    } else {
        return false;
    }
}