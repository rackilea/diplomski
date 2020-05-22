Set union = new HashSet(setA);
union.addAll(setB);

Set intersection = new HashSet(setA);
intersection.retainAll(setB);

Set unique = new HashSet(union);
unique.removeAll(intersection);