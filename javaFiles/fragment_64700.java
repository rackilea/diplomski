else {
   System.out.print("0 1 ");                 //this statement prints the start "0 1 "
   int a = 0;                                //the two starting numbers a and b are initialized
   int b = 1;
   for (int i = 1; i < n; i++) {             //for the given amount of numbers:
       int nextNumber = a + b;               //calculate the next number as sum of both previous numbers
       System.out.print(nextNumber + " ");   //print this number
       a = b;                                //set the old b as new a
       b = nextNumber;                       //set the new number as b
   }                                         //repeat
}