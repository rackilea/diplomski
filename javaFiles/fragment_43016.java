Logger beforeAsync= LoggerFactory.getLogger("beforeAsync");
Logger afterAsync= LoggerFactory.getLogger("afterAsync");

private CompletableFuture<Void> secondMethod(){
    printLongerTrace(Thread.currentThread(),beforeAsync);
    return CompletableFuture.supplyAsync(()->method(),threadPool);
}

private void methodWithException(){
    try{
    //do something
    }
    catch(Exception e){ 
      printLongerTrace(e,"methodWithException", afterAsync);
    }
}

public void printLongerTrace(Throwable t, String methodName, Logger ownlogger) {

    if (t.getCause() != null) {
        printLongerTrace(t.getCause(), methodName, fields, ownlogger);
    }
    StringBuilder builder = new StringBuilder();
    builder.append("\n Thread = " + Thread.currentThread().getName());
    builder.append("ERROR CAUSE = " + t.getCause() + "\n");
    builder.append("ERROR MESSAGE = " + t.getMessage() + "\n");

    printLog(t.getStackTrace(), builder);
    ownlogger.info(methodName + "Trace ----- {}", builder);
}

public void printLongerTrace(Thread t, Logger ownlogger) {

    StringBuilder builder = new StringBuilder();
    builder.append("\n Thread = " + Thread.currentThread().getName());

    printLog(t.getStackTrace(), builder);
    ownlogger.info("Trace ----- {}", builder);
}

private StringBuilder printLog(StackTraceElement[] elements, StringBuilder builder) {

    int size = elements.length > 15 ? 15 : elements.length;

    for (int i = 0; i < size; i++) {
        builder.append("Line " + i + " = " + elements[i] + "   with method = " + elements[i].getMethodName() + "\n");
    }
    return builder;
}