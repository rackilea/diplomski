for (int j=-1; j<=1; j++)
{
   for (int i=-1; i<=1; i++)
   {
      if(v+j>=0 && u+i>=0)
      {
         if(array[v+j][u+i]>0)
         {
            array[v][u]= nextlabel;
         }
         else{
            array[v][u] = nextlabel++;
         }
      }
   }
}