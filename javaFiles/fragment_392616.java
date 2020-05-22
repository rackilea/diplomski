public static int[][] mystry2d(int[][] a){
 for(int r = 0; r<a.length; r++){
  for(int c=0; c<a[r].length-1;c++){
   if(a[r][c+1] > a[r][c]){
    a[r][c] = a[r][c+1] ;
   }
  }
 }
 return a ;
}