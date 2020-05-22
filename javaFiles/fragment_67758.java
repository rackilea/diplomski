public static int fib(int number){
  if (number == 0){
     return 0;
  }
  else{
     int fibauxArray[] = fibaux(number);
     return fibauxArray[0];
  }
}

public static int[] fibaux(int number){
  if (number == 1){
     return new int[] {1, 0};
  }
  else{
     int[] Q = fibaux(number-1);
     int f2 = Q[0];
     int f1 = Q[1];

     return new int[] {f2+f1, f2};
 }
}