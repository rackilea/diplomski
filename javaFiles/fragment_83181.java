ConcurrentMap<String, MyType> map = new ConcurrentHashMap<>();

// the collection to retain.
for(MyType mt: retainedSet) map.put(mt.getKey(), mt);

// the collection to keep if not duplicated
for(MyType mt: onlyIfNewSet) map.putIfAbsent(mt.getKey(), mt);

// to get the intersection.
Set<String> toKeep = new HashSet<>();
for(MyType mt: onlyIfNewSet) toKeep.add(mt.getKey());

// keep only the keys which match.
map.keySet().retainAll(toKeep);