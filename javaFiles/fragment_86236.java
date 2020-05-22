public static int recursion(int x){ // x is 5
     int temp = x--; // temp is 5, x is 4
     if(x == 0){
         return 0;
     }
     else if(x > 0){
         return recursion(temp) + x*2; // calls recursion(5) again
     }
     return -1;
 }