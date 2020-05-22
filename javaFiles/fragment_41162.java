public static void Merge(Employee[] L, Employee[] R, Employee[] A)
{
   int nL = L.length;
   int nR = R.length;
   int i = 0;
   int j = 0;
   int k = 0;

   while(i < nL && j < nR)
   {
      if(L[i].getIdNumber() <= R[j].getIdNumber())
      {
         A[k] = L[i];
         k++;
         i++;
      }
      else
      {
         A[k] = R[j];
         k++;
         j++;
      }
   }
   while( i < nL)
   {
      A[k] = L[i];
      i++;
      k++;
   }
   while( j < nR)
   {
      A[k] = R[j];
      j++;
      k++;
   }
}