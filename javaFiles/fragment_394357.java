class Dummy {
   private String foo;
   private int bar;
   private Error error;

   private class Error {
        String publicMsg;
        String msg;
   }

   public boolean isError() {
       return error != null;
   }

   // setters and getters for your data, the error msg, etc.
}