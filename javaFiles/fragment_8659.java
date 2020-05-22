List<EntrySet<UUID, CustomObject>> list = new ArrayList<>(map.entrySet());
Collections.sort(list, (e1, e2) -> /*comparision here*/);
Map<UUID, CustomObject> sortedMap = new LinkedHashMap<>();
for(Entry<UUID, CustomObject> entry: list){
   sortedMap.put(entry.getKey(), entry.getValue());
}