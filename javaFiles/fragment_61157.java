try {
  //your exception throwing call here
} catch(Exception e) {
  e.setStackTrace(Arrays.stream(e.getStackTrace())
                        .filter(se -> !se.getClassName().startsWith("com.sun.proxy")) //or any other filter criteria
                        .collect(toList())
                        .toArray(new StackTraceElement[0])); //create a new stacktrace from the filtered list
  //either e.printStackStrace();
  //or rethrow
}