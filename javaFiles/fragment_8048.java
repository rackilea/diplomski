@SuppressWarnings("rawtypes")
private static void readPropertiesFile() {
    ResourceBundle rb = ResourceBundle.getBundle("com.cgi.tmi.utils.test");
    Enumeration<String> keys = rb.getKeys();
    HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
    while (keys.hasMoreElements()) {
        String key = keys.nextElement();
        String value = rb.getString(key);
        //System.out.println(key + ": " + value);
        hashMap.put(key, value.split(","));
    }
    HashMap<String, String> indexedHashMap = getValueBashedOnIndex(hashMap, 3);
    Iterator<Entry<String, String>> it = indexedHashMap.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
    }
}

@SuppressWarnings("rawtypes")
private static HashMap<String, String> getValueBashedOnIndex(HashMap<String, String[]> hashMap, int i) {
    HashMap<String, String> indexedHashMap = new HashMap<String, String>();
    Iterator<Entry<String, String[]>> it = hashMap.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        String[] strArr = (String[]) pair.getValue();
        String value = "";
        try {
            value = strArr[(i-1)];
        } catch (Exception e) {
        }
        indexedHashMap.put((String) pair.getKey(), value);
    }
    return indexedHashMap;
}