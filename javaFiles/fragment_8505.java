public void makeMatrix(String v,String w)
{
    int[][] maxDist=new int[v.length()+1][w.length()+1];
    for(int i=0;i<=v.length();i++)
    {
        for(int j=0;j<=w.length();j++)
        {
            if(i==0)
                maxDist[i][j]=-j;
            else if(j==0)
                maxDist[i][j]=-i;
            else
                maxDist[i][j]=0;
        }
    }
    fillMatrix(maxDist, v, w);
}

public int weight(String v,String w,int i,int j)
{
    if(v.charAt(i-1)==w.charAt(j-1))
        return 1;
    else
        return -1;
}

public void fillMatrix(int[][] ar,String v,String w)
{
    for(int i=1;i<=v.length();i++)
    {
        for(int j=1;j<=w.length();j++)
        {
            int scoreDiagonal=ar[i-1][j-1]+weight(v, w, i, j);
            int scoreLeft=ar[i][j-1]-1;
            int scoreUp=ar[i-1][j]-1;

            ar[i][j]=Math.max(scoreDiagonal, Math.max(scoreLeft, scoreUp));
        }
    }
}