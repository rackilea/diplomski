int[] orgArray = { 5, 4, 1, 6, 3, 144, 2, 14 };
int[] newArray = new int[orgArray.length];
// Copy the original array.
System.arraycopy(orgArray, 0, newArray, 0,
    orgArray.length);
for (int x = 1; x < newArray.length; x++) {
  int currentNum = newArray[x]; // <-- the current number changes on every loop
  int y = x;

  // The actual condition on which to shift up!
  for (; y > 0 && newArray[y - 1] > currentNum; y--) {
    newArray[y] = newArray[y - 1];
  }
  // All shifts done, insert the correct place.
  newArray[y] = currentNum;
}
System.out.println("Ascending order : "
    + Arrays.toString(newArray));