for (int i = 0; i < FirstArray.length; i++) {
  for (int j = 0; j < FirstArray.length; j++) {
    if(FirstArray[i][j]%2==1) {
        System.out.print(m1[i][j] + " "); // odd number and space
    } else {
        System.out.print(" "); // blank space for even numbers
    }
  }
  System.out.println(); // next line for next row
}