synchronized (map) {
    String value = map.get("key");
}
synchronized (map) {
    map.put("key", value+"2");
}