public static int executeCommand(CommandLine command, Logger log) throws ExecuteException, IOException {
    DefaultExecutor executor = new DefaultExecutor();
    executor.setExitValue(0);

    PumpStreamHandler psh = new PumpStreamHandler(new ExecLogHandler(log, Level.DEBUG), new ExecLogHandler(log, Level.ERROR));
    executor.setStreamHandler(psh);

    return executor.execute(command);
}