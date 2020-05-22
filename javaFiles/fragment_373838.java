public static long [][] removerow(long mat[][],int ren){
    int rengre=ren;//row to remove
    long mat2[][]= new long [mat.length-1][mat[0].length];
    int p=0;
    for( int i = 0; i <mat.length; ++i)
    {
        if ( i == rengre)
            continue;
        int q = 0;
        for( int j = 0; j <mat[0].length; ++j)
        {
            mat2[p][q] = mat[i][j];
            ++q;
        }
        ++p;
    }
        return mat2;
}