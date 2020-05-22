public LinkedHashMap<Integer, String> sortHashMapByValues(
        HashMap<Integer, String> passedMap) {
    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
    List<String> mapValues = new ArrayList<>(passedMap.values());
    Collections.sort(mapValues);
    Collections.sort(mapKeys);

    LinkedHashMap<Integer, String> sortedMap =
        new LinkedHashMap<>();

    Iterator<String> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
        String val = valueIt.next();
        Iterator<Integer> keyIt = mapKeys.iterator();

        while (keyIt.hasNext()) {
            Integer key = keyIt.next();
            String comp1 = passedMap.get(key);
            String comp2 = val;

            if (comp1.equals(comp2)) {
                keyIt.remove();
                sortedMap.put(key, val);
                break;
            }
        }
    }
    return sortedMap;
}