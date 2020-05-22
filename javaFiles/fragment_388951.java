public static final int getMaxNum(int[] numbers)  {
   int max = Integer.MIN_VALUE;
   for(int i : numbers)  {
      if(i > max)  {
         max = i;
      }
   }
   return  max;
}