Set<String> set = new HashSet<String>();
set.add("one");
set.add("two");
Set<Set<String>> setOfSets = new HashSet<Set<String>>();
setOfSets.add(set);
boolean found = setOfSets.contains(set); // returns true
set.add("three");
Set<Set<String>> newSetOfSets = new HashSet<Set<String>>(setOfSets);
found = setOfSets.contains(set); // returns false
found = newSetOfSets.contains(set); // returns true