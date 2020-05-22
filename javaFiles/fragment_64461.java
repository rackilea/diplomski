static void staircase(int n) {

   int counter=0;
   for(int i=0; i<n;i++)
   {
       counter++;
       for(int k=n; k>= i;k--)
       {
           System.out.print(" "); 
       } 
       for(int j=0; j<=counter-1;j++) 
       {
           System.out.print("#");
       }

       System.out.print("\n");
   }
}