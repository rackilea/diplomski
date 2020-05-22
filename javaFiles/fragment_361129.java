class Tester
    {
       public static void main (String args[]){

          int i=1;
          do{                          //block started with out checking condition
         System.out.print("\n");     
         int j=1;
         do {                       //inner loop starts
           System.out.print(j);
           j++;
           }while(j<=i);             //condition check for inner loop
           i++;
          }while(i<=4);             //condition check for outer loop
        }
    }