public static void main(String[] args)
{
    System.out.println(countPath(mat,0,0));
}

private static int countPath(int[][] mat, int x, int y)
{
    int n = mat.length -1;

    if (x==n && y==n)
        return 1;

    if(x>n || y>n)
        return 0;

    if(mat[x][y]==0)
        return 0;

    if(x+mat[x][y]/10 == x+mat[x][y]%10 && x+mat[x][y]%10 == x+mat[x][y]/10)
        return countPath(mat,x+mat[x][y]/10,y+mat[x][y]%10);
    else
        return countPath(mat,x+mat[x][y]/10,y+mat[x][y]%10) + countPath(mat,x+mat[x][y]%10,y+mat[x][y]/10 ); 
}