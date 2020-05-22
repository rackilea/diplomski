Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        // kill the application here!!!
        killCProgram();
    }
});