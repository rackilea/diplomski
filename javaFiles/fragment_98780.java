// Create a sorted map
Map<Integer, List<Double>> finalMap = new TreeMap<Integer, List<Double>>();

Set<Integer> keys = new HashSet<Integer>();
keys.addAll(firstMap.keySet());
keys.addAll(secondMap.keySet());
for (Integer key : keys) {
    double first  = firstMap.containsKey(key)  ? firstMap.get(key)  : 0.0;
    double second = secondMap.containsKey(key) ? secondMap.get(key) : 0.0;
    finalMap.put(key, Arrays.asList(first, second));
}