int [] numbers = {10, 20, 30, 40, 50};
   for(int x : numbers ) {
     if( x == 30 ) {
        continue;           
       }
     System.out.print( x );     //when x=30,these will not run;
     System.out.print("\n");
  }