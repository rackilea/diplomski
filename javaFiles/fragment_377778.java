static void printCurrent() {
    final StackTraceElement ste = new Throwable().getStackTrace()[1];
    String methodName = ste.getMethodName();
    String className = ste.getClassName();
    String lineNum = ""+ste.getLineNumber();
    System.out.println(className + ", " + methodName + ", Line " + lineNum);
}