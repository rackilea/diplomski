private Location getLocation(String path) {
    List strategies = new ArrayList();
    strategies.add(new RelativeFileLocatorStrategy(getBasedir()));
    strategies.add(new ClasspathResourceLocatorStrategy());
    strategies.add(new FileLocatorStrategy());
    strategies.add(new URLLocatorStrategy());

    List refStrategies = new ArrayList();
    refStrategies.add(classpathStrategy);

    Locator locator = new Locator();

    locator.setStrategies(strategies);

    Location location = locator.resolve(path);
    return location;
}