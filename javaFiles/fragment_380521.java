private static int oneRun(int range) {
    int[] rInt = new int[range+1]; // Stores the past sequence of ints.
    rInt[0] = generator.nextInt(range); // Inital random number.

    for (int count = 1; count <= range; count++) {
        ...
    }

    throw new AssertionError("unreachable code reached");
}