Multimap<Integer, String> titlesById = TreeMultimap.create<>(); // keep map ordered by ID
titlesById.putAll(1, Arrays.asList("T1a", "T1b", "T1c"));
titlesById.putAll(2, Arrays.asList("T2a", "T2b"));
titlesById.put(3, "T3");
for(Map.Entry<Integer, String> entry : titlesById.entries()){
  System.out.println("ID : " + entry.getKey() + " Title : " + entry.getValue());
}