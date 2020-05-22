public static HashMap<String, String> fromDataMap(DataMap dataMap) {
    HashMap<String, String> hashMap = new HashMap<String, String>();
    for (String key : dataMap.keySet()) {
        hashMap.put(key, dataMap.getString(key));
    }
    return hashMap;
}