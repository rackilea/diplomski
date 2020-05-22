public static int addNumbers(int value) {
   if (value > 1) {
      value += addNumbers(value - 1);
   }
   return value;
}