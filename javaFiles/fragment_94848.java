//after the warm up try the following
 int repetitions = 1000;
 start = System.nanoTime();
 for (int i=0; i<repetitions; i++) {
     //your calculations
 }
 end = System.nanoTime();
 System.out.println("Cost per repetition: " + (end - start)/repetitions);