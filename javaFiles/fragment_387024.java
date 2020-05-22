Set<Integer> bs1 = new HashSet<Integer>();
bs1.add(2);
bs1.add(5);
bs1.add(7);
bs1.add(8);

Set<Integer> bs2 = new HashSet<Integer>();
bs2.add(2);
bs2.add(7);
bs2.add(9);

bs1.retainAll(bs2);

// Prints [2, 7]
System.out.println(bs1);