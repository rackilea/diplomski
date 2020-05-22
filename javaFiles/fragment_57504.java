public int sign() {
   int val = add(0);   // add 0 and return currentValue
   if (val > 0) return 1;
   else if (val < 0) return -1;
   else return 0;
}