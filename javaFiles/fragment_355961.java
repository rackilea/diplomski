public void mergeJsonsFiles(File newJson, File oldJson) throws Exception {
    HashMap<String, Object> newMap = convertJsonToMap(newJson);
    HashMap<String, Object> oldMap = convertJsonToMap(oldJson);

    for (Entry<String, Object> entry : oldMap.entrySet()) {
        if (newMap.get(entry.getKey()) == null) {
            newMap.put(entry.getKey(), entry.getValue());
        }
    }

    ObjectMapper mapper = new ObjectMapper();
    String jsonFromMap = mapper.writeValueAsString(newMap);

    PrintWriter writer = new PrintWriter(newJson);
    writer.write(jsonFromMap);
    writer.close();
}

private HashMap<String, Object> convertJsonToMap(File json) {
    ObjectMapper mapper = new ObjectMapper();
    HashMap<String, Object> map = new HashMap<String, Object>();
    try {
        map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>(){});
    } catch (IOException e) {
        map.clear();
    }
    return map;
}