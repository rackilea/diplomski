public StackTraceElement(String declaringClass, String methodName,
                             String fileName, int lineNumber) {
  this.declaringClass = Objects.requireNonNull(declaringClass, "Declaring class is null");
  this.methodName     = Objects.requireNonNull(methodName, "Method name is null");
  this.fileName       = fileName;
  this.lineNumber     = lineNumber;
 }