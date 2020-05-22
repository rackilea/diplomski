private HashMap<String, HashMap<String, HashMap<String, Integer>>> countTags(String statType, String objectType,
        String opType, HashMap<String, HashMap<String, HashMap<String, Integer>>> parentMap) {
    if (!Util.isEmpty(parentMap) && parentMap.containsKey(statType)) {
        // if objType is present, count the tags
        if (parentMap.get(statType).containsKey(objectType)) {
            HashMap<String, Integer> objMap = parentMap.get(statType).get(objectType);
            HashMap<String, Integer> map = countTags(objectType, opType, objMap).get(objectType);
            parentMap.get(statType).get(objectType).putAll(map);
        } else {
            // if objType isn't present, add that objType and count the tags
            HashMap<String, HashMap<String, Integer>> map = countTags(objectType, opType,
                    new HashMap<String, Integer>());
            parentMap.get(statType).put(objectType, map.get(objectType));
        }
    } else {
        // first time add the new tag to calculate it's object/operation wise
        // distribution
        parentMap.put(statType, countTags(objectType, opType, new HashMap<String, Integer>()));
    }
    return parentMap;
}