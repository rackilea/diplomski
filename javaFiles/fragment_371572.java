private static String getKeyByValue(Map<String, List<MyItem>> map, String searchKeyWord) {
    return map.entrySet().stream()      //all entries in the map
            .filter(e -> e.getValue().stream()
                    .anyMatch(i -> i.getName().equals(searchKeyWord))) //take only the ones which have searchKeyword in their list
            .findAny()                  //take just one such entry
            .map(Map.Entry::getKey)     //change Entry to String (the key)
            .orElse(null);              //if there is no such entry, return null
}