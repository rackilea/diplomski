List<Integer> integers = new ArrayList<>();
integers.add(17);
integers.add(42);
integers.add(2001);
List<Integer> unmodifiable = Collections.unmodifiableList(integers);
unmodifiable.set(0, 1);                  // throws.
unmodifiable.remove(0);                  // throws.
unmodifiable.add(867_5309);              // throws.
integers.set(0, 1)                       // okay.
System.out.println(unmodifiable.get(0)); // Prints 1.