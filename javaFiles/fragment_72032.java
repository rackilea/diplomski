Set<Equivalence.Wrapper<String>> identityHashSet = Sets.newHashSet();

String a1 = "a";
String a2 = new String("a");
String b = "b";

identityHashSet.add(Equivalences.identity().wrap(a1));
identityHashSet.add(Equivalences.identity().wrap(a2));
identityHashSet.add(Equivalences.identity().wrap(a3));

// identityHashSet contains "a", "a", and "b"
// a standard HashSet would only contain "a" and "b"
// while a1 and a2 are equal according to String.equals(), they are different instances.