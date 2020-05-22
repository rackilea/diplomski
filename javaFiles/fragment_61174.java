class PropertiesFactory extends AbstractObjectCreationFactory<Properties> {

    Properties defaultProperties;

    public PropertiesFactory(Properties defaultProperties) {
        super();
        this.defaultProperties = defaultProperties;
    }

    @Override
    public Properties createObject(Attributes attributes) throws Exception {
        return new Properties(defaultProperties);
    }

}

...
...

forPattern("properties").factoryCreate()
        .usingFactory(new PropertiesFactory(defaultProperties));
forPattern("properties/property")
        .callMethod("put").withParamCount(2)
        .withParamTypes(Object.class, Object.class).then()
        .callParam().fromAttribute("name").ofIndex(0).then()
        .callParam().ofIndex(1);