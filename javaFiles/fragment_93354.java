try {
   m.invoke();
catch (InvocationTargetException e) {
   Throwable originalException = e.getTargetException();
   for (StackTraceElement element : originalException.getStackTrace()) {
       System.out.println(el);
   }
}