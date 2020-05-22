int contains(int value, int[] list) {
   if(list.length == 0) {
      return false;
   }

   if(list.length == 1) {
       return list[0] == value;
   }

   return contains(value, firstHalf(list)) || 
          contains(value, secondHalf(list));
}