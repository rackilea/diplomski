Map<String, SortedSet<Car>> makeSetMap = new HashMap<String, SortedSet<Car>>();

// ...

for(String key: makeSetMap.keySet()) { // loop through all manufacturers
   SortedSet<Car> cars = makeSetMap.get(key);
   for(Car c: cars) { // loop through all cars of that key
       System.out.println(key + " " + car);
   }
}