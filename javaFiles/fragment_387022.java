BitSet bs1 = new BitSet();
bs1.set(2);
bs1.set(5);
bs1.set(7);
bs1.set(8);

BitSet bs2 = new BitSet();
bs2.set(2);
bs2.set(7);
bs2.set(9);

bs1.and(bs2);

// Prints {2, 7}
System.out.println(bs1);