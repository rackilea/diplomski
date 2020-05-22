long[][]memo;  //Memo table

public long C(int n)
{
    if (n == 1)
        return 0;

    memo=new int[n+1][n+1]; //Increase to n+1 and won't crash!

    for(int i=0;i<=n;i++)
        for(int j=0;j<=n;j++)
            memo[j][i]=-1;

    return C(n, 0, 0, memo);
}

private long C(int n, int i, int j, it) {

    // CAN MOVE UP & RIGHT
    if (j - i > 0 && j + 1 <= n)
    {
        if(memo[i+1][j]==-1)
            memo[i+1][j]=paths(n, i + 1, j);

        if(memo[i][j+1]==-1)
            memo[i][j+1]=paths(n, i, j + 1);

        return memo[i+1][j]+memo[i][j+1];
    }
    // CAN MOVE UP
    else if (j - i > 0)
    {
        if(memo[i+1][j]==-1)
            memo[i+1][j]=paths(n, i + 1, j);
        return memo[i+1][j];
    }
    // CAN MOVE RIGHT
    else if (j + 1 <= n)
    {
        if(memo[i][j+1]==-1)
            memo[i][j+1]=paths(n, i, j + 1);
        return memo[i][j+1];
    }
    // CAN'T MOVE
    else
        return 1;
}