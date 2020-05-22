public static VectorADT add(VectorADT one, VectorADT two) 
{
   int [] sum = new int [one.vector.length];
   for(int i = 0; i < one.vector.length; i++)
   {
       sum[i] = one.vector[i] + two.vector[i];
   }
   return new VectorADT(sum);
}