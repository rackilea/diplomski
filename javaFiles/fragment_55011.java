public Map<String, MyObj> getByCriteria(int criteria) {
  return map1.entrySet()
      .parallelStream() //this is your speedup
      .filter(e -> e.getValue().criteria = criteria)
      .collect(toConcurrentMap(Entry::getKey, Entry::getValue));
}