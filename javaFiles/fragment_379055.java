public static void runWithoutMasking() throws MyException {
   AutoClose autoClose = new AutoClose();
   MyException myException = null;
   try {
       autoClose.work();
   } catch (MyException e) {
       myException = e;
       throw e;
   } finally {
       if (myException != null) {
           try {
               autoClose.close();
           } catch (Throwable t) {
               myException.addSuppressed(t);
           }
       } else {
           autoClose.close();
       }
   }
}