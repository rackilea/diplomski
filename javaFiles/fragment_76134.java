Map<String, String> assocArray = new LinkedHashMap<String, String>();

for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
    String name = entry.getKey();

    if (name.startsWith("assocArray[")) {
        String key = name.substring(name.indexOf('[') + 1, name.indexOf(']')); 
        assocArray.put(key, entry.getValue()[0]);
    }
}