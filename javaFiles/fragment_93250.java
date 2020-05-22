float **allocate_mem_m(int m, int n)
{
 int i;
 float **arr = malloc(n*sizeof(*arr));
 for(i=0;i<n;i++)
   {
     arr[i]=malloc(m*sizeof(**arr));
   }
 return arr;
} 


float **transpose(int m, int n, float Xy[]) {
  int i,j;
  float **result = allocate_mem_m(m,n);
  for(i = 0; i < m; i++) {
    for(j = 0; j < n; j++) {
      result[i][j] = Xy[j*n+i];
    }
  }
  return result;
}