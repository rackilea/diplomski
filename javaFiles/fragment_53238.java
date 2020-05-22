if (LOGGER.isDebugEnabled()){
   String className = method.getDeclaringClass().getName();
   String methodName = method.getName();
   long id = Thread.currentThread().getId();
   String name = Thread.currentThread().getName();
   String msg = String.format("some text, for: %s %s in thread %d %s", className, methodName, id, name);
   LOGGER.debug("xxxxxxxx {}", msg);
 }