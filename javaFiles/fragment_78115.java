Map<Integer, String> firstMap = new HashMap<Integer, String>();
Map<Integer, String> secondMap = new HashMap<Integer, String>();

for (Entry<Integer, String> firstEntry : firstMap.entrySet()) {
  String firstMapValue = firstEntry.getValue();
  String secondMapValue = secondMap.get(firstEntry.getKey());
  System.out.println(firstEntry.getKey() + " " + firstMapValue + " " + secondMapValue + " " + firstMapValue.equals(secondMapValue));
}