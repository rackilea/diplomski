List<Map> counts = ...

List<Map> copy = new ArrayList<>();
for(Map m : counts){
  copy.add(new HashMap(m));
}