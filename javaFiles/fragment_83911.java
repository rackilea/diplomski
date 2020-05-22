// Are there any negative numbers?
if (neg > 0) {
  System.out.println("The negative numbers are: ");
  for (int x = 0; x < neg; x++) {
    if (x != 0) {
      // Add a comma between entries.
      System.out.print(", ");
    }
    // Print the number at x (where x is 0 to neg).
    System.out.print(negativeList[x]);
  }
  // Add a new line.
  System.out.println();
}