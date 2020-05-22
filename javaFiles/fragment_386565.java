int[][] x = new int[][] { { 1,3 }, { 5,7 }  };
    int[][] copyOfX = x.clone( );
    copyOfX[1][1]=13;

    for ( int i = 0; i < 2; i++ )
    {
        System.out.println(x[i] + "/" + copyOfX[i]);
        for ( int j = 0; j < 2; j++ )
        {
            System.out.println(x[i][j] + "/" + copyOfX[i][j]);
        }
    }