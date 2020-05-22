public int min(int[] array) {
   int min = Integer.MAX_VALUE;

   if (array == null) return min;

   const int count = array.length;
   for (int i=0; i<count; i++) {
      min = min < array[i] ? min : array[i];
   }

   return min;
}