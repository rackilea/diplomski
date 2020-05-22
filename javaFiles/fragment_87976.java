for (String key : map.keySet()) {
    String value = map.get(key);
}

for (String value : map.values()) {
}

for (Map.Entry<String,String> entry : map.entrySet()) {
    String key = entry.getKey();
    String value = entry.getValue();
}