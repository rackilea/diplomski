Random rand = new Random();
    int[][] list = new int[10][10];

    for (int r = 0; r < list.length; r++)
    {
        for (int c = 0; c < list[r].length; c++)
        {
            list[r][c] =  rand.nextInt(500) + 1;
            System.out.print(list[r][c] + " "); // print on this line
        }
        // this occurs when you're done displaying each row, so skip a line.
        System.out.println();
    }