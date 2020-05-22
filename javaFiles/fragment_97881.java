public static void printCurrentFileAndLine() {
    final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
    for (int i=0; i<ste.length; i++)
        if (ste[i].getMethodName().equals("printCurrentFileAndLine")) {
            System.out.println("I just hit file@line: "+ste[i+1].getFileName() +'@'+ ste[i+1].getLineNumber() );
            break;
        }
}