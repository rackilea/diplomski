public static boolean findSum(int[][] m ,int s, int[][]p){
    return findSum(m,s,p,0,0); //calling overloading
}

private static boolean findSum(int[][] m, int s, int[][] p, int i, int j) {
    if (i<0 || i>=m.length) return false; //stop condition
    if (finder(m,s,p,i,j)) return true; //first recursion
    if (j<m[0].length-1) //if the iterator is not on the end of the row 
        return  findSum(m,s,p,i,j+1); //recursive call 
    else //if i checked the whole row , the column will be increase.
        return findSum(m,s,p,i+1,0);//recursive call

}

private static boolean finder(int[][] m, int s, int[][] p, int i, int j) {
    if (s == 0) return true;
    if (i<0 || i>=m.length || j<0 || j>=m.length || s<0 || p[i][j] == 1) return false;

    p[i][j] =1;
    boolean u=false,d=false,r=false,l=false;
    if (i>0) u = finder(m,s-m[i][j],p,i-1,j);
    if (i<m.length-1) d = finder(m,s-m[i][j],p,i+1,j);
    if (j>0) l = finder(m,s-m[i][j],p,i,j-1);
    if (i<m.length-1) r = finder(m,s-m[i][j],p,i,j+1);
    if (u) return true;
    else if (d) return true;
    else if (r) return true;
    else if (l) return true;
    else {
        p[i][j] = 0;
        return false;
    }
}