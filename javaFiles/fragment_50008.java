Multimap<String, String> mmap = HashMultimap.create();

mmap.put("APP", "TR202");
mmap.put("APP", "TR204");
mmap.put("APP", "TR205");
mmap.put(null, "TR206");
mmap.put(null, "TR207");
mmap.put(null, "SM504");
mmap.put(null, "SM505");

for (String key : mmap.keySet()) {
  for (String value : mmap.get(key)) {
    System.out.println(key + ": " + value);
  }
}