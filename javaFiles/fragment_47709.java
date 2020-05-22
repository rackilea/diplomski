private static void div(int i, int j) {

      try {   // NESTED HERE

        try {
            System.out.println(i / j);
        } catch(ArithmeticException e) {
            Exception ex = new Exception(e);
            throw ex;
        }

      // THIS GOES WITH THE OUTER NESTED 'try'
      } catch( Exception x ) {
         System.out.println( "Caught a second exception: " + x );
      }
    }