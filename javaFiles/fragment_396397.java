public Map<String, List<String>> getMapWithListOfStrings() {
    Map<String, List<String>> returningMap = new HashMap<>();
    List<String[]> readAll = csvReader.readAll();
    String[] keys = readAll.get(0);
    for (int i = 0; i < keys.length; i++) {
        String key = keys[i];
        List<String> value = new ArrayList<>();
        // j = 0 is excluded - it contains the keys, not the values
        for(int j = 1; j < readAll.size(); j++) {
            String iValue = readAll.get(j)[i];
            value.add(iValue);
        }
        returningMap.put(key, value);
    }
    return returningMap;
}