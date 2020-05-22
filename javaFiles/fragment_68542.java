Map<Integer, List<Employee>> map = new HashMap<>();
for(Farm f : FarmList){
  for(Employee e : f.emp){
    if(!map.containsKey(e.salary)){
      map.put(e.salary, new ArrayList<>());
    }
    map.get(e.salary).add(e);
  }
}