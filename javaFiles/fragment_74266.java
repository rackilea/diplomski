List<String> existingList = map.get(key);
if (existingList == null){
   existingList = new ArrayList<String>();
   map.put(key, existingList);
}
existingList.addAll(someList);