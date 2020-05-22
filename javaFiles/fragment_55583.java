int exitCode;
try {
    Process process = Runtime.getRuntime().exec("java AnotherClass.jar",new String[]{"arg1","arg2"});
    exitCode = process.waitFor();
    System.out.println(exitCode);
} catch (IOException e) {
    System.out.println("IO Error: " + e);
} catch (InterruptedException e) {
    System.out.println("Inturrupted: " + e);
}