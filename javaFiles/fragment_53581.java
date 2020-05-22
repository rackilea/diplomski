Set<String> removedKeys = new HashSet<String>(beforeMap.keySet());
removedKeys.removeAll(afterMap.keySet());

Set<String> addedKeys = new HashSet<String>(afterMap.keySet());
addedKeys.removeAll(beforeMap.keySet());

Set<Entry<String, String>> changedEntries = new HashSet<Entry<String, String>>(
        afterMap.entrySet());
changedEntries.removeAll(beforeMap.entrySet());

System.out.println("added " + addedKeys);
System.out.println("removed " + removedKeys);
System.out.println("changed " + changedEntries);