public static int findNeighbors(int x, int y, int[][] a) {
    int sum = 0;
    for ( int i = (y>0 ? y-1 : 0); i <= (y<a.length-1 ? y+1 : a.length-1); ++i )
        for ( int j = (x>0 ? x-1 : 0); j <= (x<a[0].length-1 ? x+1 : a[0].length-1); ++j )
            sum += a[i][j];
    sum -= a[y][x];
    return sum;
}