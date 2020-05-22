//Call this method when you want to calculate the factorial
public int factorial(int num){
   for(int i = num-1; i > 1; i--){
       num *= i;
   }
   return num;
}