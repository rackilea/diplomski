printLog(Process process, String processLog, TerminalLogHolder logHolder){
    ReadStream s1 = new ReadStream("stdin", process.getInputStream (), logHolder);
    s1.start ();
}

public static class ReadStream implements Runnable {
    private String name;
    private String cmdId;
    private InputStream is;
    private Thread thread;

    private TerminalLogHolder terminalLogHolder;

    public ReadStream(String name, InputStream is, String cmdId, TerminalLogHolder logHolder) {
        this.name = name;
        this.is = is;
        this.cmdId = cmdId;
        this.terminalLogHolder = logHolder;
    }
}