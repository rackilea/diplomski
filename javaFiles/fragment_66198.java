int row = 1;
    int k = 0;
    String row1Values4x4 = "-1";
    int[][] arraySidesInteger = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

    while (row <= 4) {

        boolean done = false;

        while (!done) {

            Scanner firstRow4x4 = new Scanner(System.in);
            System.out.println("Please enter four values using commas for row " + row); // this needs to loop
            row1Values4x4 = firstRow4x4.next();
            String[] values = row1Values4x4.split(",");

            for (int i = 0; i < values.length; i++) { //Logic to validate the value

                if (Integer.parseInt(values[i]) < 0
                        || Integer.parseInt(values[i]) > 4) {
                    System.out
                            .println("You have entered the value which not fit in the boundary.Please Try again.");
                    done = true;
                    break;
                }
            }

            if (done) { // Loop again to get the row value correctly.
                done = false;
                continue;
            }

            //Adding the value to row
            for (int i = 0; i < values.length; i++) {
                arraySidesInteger[row - 1][i] = Integer.parseInt(values[i]);
            }

            row++;
            done = true;

        }
    }

    //Prints the array
    for (int i = 0; i < arraySidesInteger.length; i++) {
        for (int j = 0; j < arraySidesInteger.length; j++)
            System.out.print(arraySidesInteger[i][j] + " ");
        System.out.println();
    }

}