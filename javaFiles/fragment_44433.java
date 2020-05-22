public enum EventType {
     FREE_EVENT,  // Use default implementations for methods
     CHARITY_EVENT {
          public void isFree() {
              return false;
          }
          public int cost() {
              return 1000;
          }
     };

     public boolean isFree() {
         return true;
     }

     public int cost() {
         return 0;
     }
}