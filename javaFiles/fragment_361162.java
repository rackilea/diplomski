Price[][] binomialTree = new Price[20][];
     for ( int i = 0 ; i < 20 ; i++ ) {
         binomialTree[i] = new Price[i+1];
     }

     for ( int i = 0; i < 20; i ++ ) {
          System.out.println( Arrays.toString(binomialTree[i]));
     }