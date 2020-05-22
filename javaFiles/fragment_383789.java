int[][] array = new int[N][N];
    int percentage = N*N/10;
    int filled = 0;
    while(filled <= percentage)
    {
        Random rand = new Random();
        int i = rand.nextInt(N+1);
        int j = rand.nextInt(N+1);
        if(array[i][j] == 0)
        {
            filled++;
            array[i][j] = 1;
        }
    }
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            System.out.print(array[i][j] + " ");
        }
        System.out.println();
    }