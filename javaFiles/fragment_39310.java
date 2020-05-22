// We use array1 only as input
final int[] array1 = {1, 2, 3, 0};
final int[] powResult = firstSteps.cube(array1);
int[] arrayResult1 = {1, 8, 27, 0};

// We use the returned powResult for comparison,
// as array1 has not been touched.
assertArrayEquals(arrayResult1, powResult);