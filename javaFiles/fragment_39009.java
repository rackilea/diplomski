public void loadXmlFile(String filename) {
    XMLConfiguration config = null;
    try {
        config = new XMLConfiguration(filename);
    } catch (ConfigurationException e) {
        e.printStackTrace();
    }
    Iterator<String> keyIter = config.getKeys();
    String key;
    while (keyIter.hasNext()) {
        key = keyIter.next();
        Object prop = config.getProperty(key);
        if(prop instanceof Collection) {
                List<String> values = (List<String>) prop;
                for(String value : values){
                    System.out.println(key + "=" + value);
                }
        } else {
            System.out.println(key + "=" + prop);
        }
    }
}