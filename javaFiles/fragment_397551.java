for (int i = 0; i < array2d.length; i++) {
    for (int j = 0; j < array2d[0].length; j++) {
            //int a = 1;
            //a++;
            //int b = 1;
            //b++;
            int loopResult = toPowerOf(i+1, j+1);
            array2d[i][j] = loopResult;
            System.out.println("The variable at " + i + " " + j
                    + " is: " + array2d[i][j]);
    }
}