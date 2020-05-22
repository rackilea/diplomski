final NavigableMap<String, MyData> entryMap = new TreeMap<>();

// add each entry by full path to the entryMap
entryMap.put(fullpath, new MyData(... ... ...));

// later process the entries in the order required
File lastDirectory = new File("/");
for(Map.Enrty<String, MyData> entry : entryMap.entrySet()) {
   File file = new File(entry.getKey());
   MyData myData = entry.getValue();
   if (!file.getParent().equals(lastDirectory.getParent()) {
        // different directory
   }