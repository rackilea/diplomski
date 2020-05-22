java.lang.Throwable e = ...
StackTraceElement[] trace = e.getStackTrace();
for (StackTraceElement element : trace) {
  System.out.println(element.getClassName());
  System.out.println(element.getMethodName());
  System.out.println(element.getFileName());
  System.out.println(element.getLineNumber());
}