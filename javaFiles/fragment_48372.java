boolean contains(int value, int[] list) {
   if(list.length == 0) {
        return false;
   } 

   if(list[0] == value) {
      return true;
   }

   return contains(value, tail(list));
}