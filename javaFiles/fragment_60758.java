Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
   @Override
   public void uncaughtException(Thread t, Throwable e) {
       StackTraceElement[] stackTrace = e.getStackTrace();
       if (e instanceof NullPointerException &&
           stackTrace != null && stackTrace.length >= 0 &&
           "Statistics.java".equals(stackTrace[0].getFileName()) &&
           "hashString".equals(stackTrace[0].getMethodName()) &&
           192 == stackTrace[0].getLineNumber()) {
           // Handle your exception here.
       }
   }
});