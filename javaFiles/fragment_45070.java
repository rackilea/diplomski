int dl = CountFileLines("data.txt");
if (dl == 0) { System.exit(0); }
String[][] myArray = new String[dl][5];
myArray = applyFileDataToArray("data.txt", myArray);

// Display the contents of our 2D Array to Console...
for (int i = 0; i < myArray.length; i++) {
    System.out.println("\nROW " + (i+1) + ":");
    for (int j = 0; j < 5; j++) {
        System.out.println("\tColumn " + (j+1) + ":  " + myArray[i][j]);
    }
}