HashMap<String, Person> personsById = new HashMap<>();
for (Map.Entry<String,Person> e : personsMap.entrySet()) {
    String key = e.getKey();
    Person val = e.getValue();
    if (idSet.contains(val.getId()) personsById.put(key, val);
}