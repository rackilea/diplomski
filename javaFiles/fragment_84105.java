List<Integer> original = new ArrayList<>();
original.add(1);
original.add(2);
original.add(3);
ImmutableList<Integer> immutable = ImmutableList.copyOf(original);
immutable.set(0, 42);  // throws.
System.out.println(immutable.get(0)); // Prints 1.
original.set(0, 42);   // fine.
System.out.println(immutable.get(0)); // Prints 1.
ImmutableList<Integer> copy = ImmutableList.copyOf(immutable);
    // Shares immutable's data.