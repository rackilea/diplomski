public Properties loadProperties(String name) {
    if(properties == null){
        return loadProperties(name, Thread.currentThread().getContextClassLoader());
    } else {
        return properties;
    }
}