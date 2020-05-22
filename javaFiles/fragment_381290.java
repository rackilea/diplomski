public static void main(String[] args) {
    try {
        CommandLine cmdLine = new CommandLine("/bin/bash");
        DefaultExecutor executor = new DefaultExecutor();
        OutputStream os = new ByteArrayOutputStream();
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream  pis = new PipedInputStream(pos);
        executor.setStreamHandler(new PumpStreamHandler(os, null, pis));
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        executor.execute(cmdLine, resultHandler);

        PrintWriter pw = new PrintWriter(pos);
        pw.println("ls -l /usr");
        pw.println("pwd");
        pw.close();
        resultHandler.waitFor();
        System.out.println(os.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}