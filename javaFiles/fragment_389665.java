private LinkedHashMap<String, String> getMap(String rawData) {
    LinkedHashMap<String, String> map = new LinkedHashMap<>(); // change
    String[] pairs = rawData.split(","); // split into key-value pairs
    for(String pair: pairs) {
        pair = pair.trim(); // get rid of extraneous white-space
        String[] components = pair.split("=");
        String key = components[0].trim();
        String value = components[1].trim();
        map.put(key, value); // put the pair into the map
    }
    return map;
}