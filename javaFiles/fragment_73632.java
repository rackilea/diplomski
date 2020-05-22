public boolean isStraight(int d1, int d2, int d3) {
   int min = getMin(d1, d2, d3);
   int mid = getMid(d1, d2, d3);
   int max = getMax(d1, d2, d3);

   if((max - mid) == 1 && (mid - min) == 1) {
     return true;
   } else {
     return false;
   }
}