//you initial data
Dataset initialData;
//map values to has set with counts initiali 1 for every element
initialData.map((key, value) => {
  Map<Character, Integer> res = new HashMap<>();
  res.add(value, 1);
  Tuple2<Character, Map<Character, Integer>> tuple = new Tuple2<>(key, res);
  return tuple;
//count elements for given key
}).reduceByKey((map1, map2) => {
  final Map<Character, Integer> res = new HashMap<>();
  res.putAll(map1);
  map2.foreach((key, value) => {
    if (res.contains(key))
      res.put(key, map2(key) + value);
    else
      res.put(key, map2(key));
  }
  return res;
//sort values by count
}.map((key, value) => {
  List<SetEntry<Character, Integer>> entryList = new ArrayList<>(value.entrySet());

  collection.sort(entryList, (entry1, entry2) => 
    entry1.getValue() < entry2.getValue());
  return new Tuple2<>(key, entryList);
}