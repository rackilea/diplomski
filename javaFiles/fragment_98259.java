// Example from question:
System.out.println(findCycles(new int[] { 1, 2, 3, 4, 5, 6 },
                              new int[] { 5, 3, 2, 6, 4, 1 }));

// Examples from https://en.wikipedia.org/wiki/Cyclic_permutation:
System.out.println(findCycles(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                              new int[] { 4, 2, 7, 6, 5, 8, 1, 3 }));
System.out.println(findCycles(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
                              new int[] { 4, 5, 7, 6, 8, 2, 1, 3 }));
System.out.println(findCycles(new int[] { 1, 2, 3, 4 },
                              new int[] { 1, 4, 3, 2 }));

// Support for negative and multi-digit values:
System.out.println(findCycles(new int[] { -5, 0, 5, 10, 15, 20 },
                              new int[] { 0, 5, -5, 10, 20, 15 }));