Set<String> deletions = new HashSet<>(mySet1); // create a copy of mySet1
deletions.removeAll(mySet2);
System.out.println("deletions: " + deletions);

// Remove all elements of mySet1 from mySet2
Set<String> updates = new HashSet<>(mySet2); // create a copy of mySet2
updates.removeAll(mySet1);
System.out.println("updates: " + updates);