System.out.println("You entered: ");
    // return the entered array in double form
for (int i = 0; i < myArray.length; i++) {
    for (int j = 0; i < myArray[i].length; j++){
       System.out.print(myArray[i][j] + " ");
    }
    System.out.println();
}
System.out.println("The sums are: ");
// calculate the sums column by column and display the results
    for(int column = 0; column < myArray[0].length; column++) {
        double total = 0;
        for(int row = 0; row < myArray.length; row++)
            total += myArray[row][column];
        System.out.print(total + " ");

    }