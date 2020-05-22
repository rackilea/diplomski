public static long timeTaken() {

     long startTime = System.currentTimeMillis();
     long time = 0;

     for(int i = 0; i < 1000; i++) {
        time += i;
     }

     long endTime = System.currentTimeMillis();
     long diff = endTime - startTime;
     System.out.println(diff ); //prints time taken
     return diff;
  }