boolean success = false;
do {
   try {
      // do imageIO stuff
      success = true;      // this statement only reached if no exception
   } catch (Exception e) {
      System.err.println(e);
   }
} while (!success);