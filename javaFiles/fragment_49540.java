@Autowired
private Environment environment;

/**
 * Checks if the local.yml was loaded.
 *
 * @return true if the local.yml was laoded
 */
public boolean isLocalAppConfigLoaded() {
    MutablePropertySources propertySources = ((AbstractEnvironment)environment).getPropertySources();
    return StreamSupport.stream(propertySources.spliterator(), false)
        .filter(propertySource -> propertySource instanceof EnumerablePropertySource)
        .map(PropertySource::getName)
        .anyMatch(sourceName -> sourceName.matches("^applicationConfig: \\[.*?local.yml]$"));
}