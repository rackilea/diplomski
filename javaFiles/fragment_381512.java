TreeSet<String> s1 = new TreeSet<String>(mapA.keySet());
Set<String> s2 = mapB.keySet();
s1.retainAll(s2);

List<String> result = new ArrayList<>();
result.addAll(s1);