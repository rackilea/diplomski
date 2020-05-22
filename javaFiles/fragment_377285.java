// Manual finalizer chaining
   @Override protected void finalize() throws Throwable {
       try {
           ... // Finalize subclass state
       } finally {
           super.finalize();
   } 
}