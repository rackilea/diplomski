//Since you know the the array will be 3x3,
    //declare it!
    int[][] array1 = new int[3][3];
    int[][] array2 = new int[3][3];

    int array1Total = 0;
    int array2Total = 0;
    int endResult;

    for (int x = 0; x < array1.length; x++) {

        for (int y = 0; y < array1[x].length; y++) {

            array1[x][y] = r.nextInt();
            array2[x][y] = r.nextInt();

        }
    }

    for (int x = 0; x < array1.length; x++) {

        for (int y = 0; y < array1[x].length; y++) {

            array1Total += array1[x][y];
            array2Total += array2[x][y];

        }
    }

    endResult = array1Total + array2Total;