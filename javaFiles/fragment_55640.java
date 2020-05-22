public enum Server{
      INSTANCE;

      public Server getInstance(){
          return INSTANCE;
      }

      private Server(){...}

      // rest of methods here
 }