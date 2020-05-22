public Map<String, String> getSystemProperties() {
    Properties localProperties = System.getProperties();
    HashMap localHashMap = new HashMap();

    Set localSet = localProperties.stringPropertyNames();
    for (String str1 : localSet) {
      String str2 = localProperties.getProperty(str1);
      localHashMap.put(str1, str2);
    }

    return localHashMap;
}