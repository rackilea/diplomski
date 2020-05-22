String[] names = ...
Map<String, Integer> map = new HashMap<>(names.length);
for (String name : names) {
   Integer count = map.get(name);
   if (count == null) {
       count = 0;
   }
   map.put(name, count + 1);
}
int count = 0;
for (Map.Entry<String, Integer> entry : map.entrySet()) {
   if (entry.getValue() > 1) {
      count += entry.getValue();
   }
}