public static Map<String, String> getMessageMap(Locale locale) {
    Properties properties;
    Set<Object> objkeys;


    if (messageMap == null) {
        messageMap = new HashMap<String, String>();
        // 1 Get properties file.
        properties = MKCLUtility.loadPropertiesFile(locale);

        // 2 Get all keys of properties file.
        objkeys = properties.keySet();

        // 3 Add all key values into map.
        Iterator<Object> iterator = objkeys.iterator();
        while (iterator.hasNext()) 
        {
            String keyName = iterator.next().toString();
            if (keyName.contains("global.")) {
                messageMap.put(keyName, properties.getProperty(keyName));
            }
        }
    }
    return messageMap;
}