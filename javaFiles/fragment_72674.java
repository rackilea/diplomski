public static String num(int number){

   for (int i = 2 ; i<number ;i++){
     if(number %i == 0) {
          // it has an exact factor.
          return "it is not prime" ;
     }
   }
   return "it is prime" ;
}