for (String propertyName : properties.stringPropertyNames()) {
    String systemPropertyValue = System.getProperty(propertyName);

    if (systemPropertyValue != null) {
        properties.setProperty(propertyName, systemPropertyValue);
    }
}