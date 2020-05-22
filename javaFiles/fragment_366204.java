public static long calculator(int num){
   long fact=1;
   for(int i = 1; i<=num; i++){
      fact *= i;
   }
   return fact;
}