public class EmptyException extends Exception {
         public EmptyException() {
         }
        public class InnerException extends Exception { //Inner class
           public InnerException() {
               }

          }
    }