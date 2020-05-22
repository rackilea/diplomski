public static class MissingFieldException extends Exception {
     public MissingFieldException() { } 
     public MissingFieldException( String msg ) {
          super( msg );
     }
}