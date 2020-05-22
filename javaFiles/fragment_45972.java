Map<Integer, String> map = new HashMap<Integer, String>();
map.put(1, "cat");
map.put(2, "dog");
map.put(3, "car");
map.put(4, "cat");
map.put(5, "dog");
map.put(6, "dog");

Map<String, Integer> uniqueValues = new HashMap<>();

for (Entry<Integer, String> entry : map.entrySet()) {
    Integer key = entry.getKey();
    String val = entry.getValue();
    if (uniqueValues.containsKey(val)) {
        key = uniqueValues.get(val);
    }

    uniqueValues.put(val, key);
    System.out.println("Key : " + key + " - Value : " + val);
}