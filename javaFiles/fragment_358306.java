public static DataMap toDataMap(HashMap<String, String> hashMap) {
    DataMap dataMap = new DataMap();
    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
        dataMap.putString(entry.getKey(), entry.getValue());
    }
    return dataMap;
}