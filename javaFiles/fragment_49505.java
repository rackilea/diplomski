public static String reverse1(int number){
   if (number == 1){
      return "1";
   } else {
      return number + ", " + reverse1(number - 1);
   }
}