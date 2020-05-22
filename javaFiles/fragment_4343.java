double originalArray[] = {1991.00, 300.50, 498.50};
double newArray[][] = new double[originalArray.length][2];
for (int i=0; i<originalArray.length; i++) {
    newArray[i][0] = i                              // Fill the 1st column with sth like ID
    newArray[i][1] = originalArray[i];              // Copy the 1D array to the 2nd column
}
System.out.println(Arrays.deepToString(newArray));  // Print all the array values