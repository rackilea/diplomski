Map<Integer, String> titlesById = new TreeMap<>(); // keep map ordered by ID
titlesById.put(1, "T1");
titlesById.put(2, "T2");
titlesById.put(3, "T3");
for(Map.Entry<Integer, String> entry : titlesById.entrySet()){
  System.out.println("ID : " + entry.getKey() + " Title : " + entry.getValue());
}