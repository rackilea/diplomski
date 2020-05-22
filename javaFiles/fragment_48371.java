int max(int[] list) {
   if(list.length == 1) {
        return list[0];
   } else {
        return Math.max(list[0], max(tail(list)));
   }
}