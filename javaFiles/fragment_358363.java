private final Executor executor = new DefaultExecutor();

    private final ExecuteWatchdog watchDog = new ExecuteWatchdog(ExecuteWatchdog.INFINITE_TIMEOUT);

    private final ProcessDestroyer shutdownHookProcessDestroyer = new ShutdownHookProcessDestroyer();

    private final DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler() {
        @Override
        public void onProcessFailed(ExecuteException ex) {
            super.onProcessFailed(ex);
            LOG.error("Error executing xxx.exe", ex);
        }
    };

    public void startInSaveRecordMode(Long callId, File pathToResult) throws IOException {
        CommandLine commandLine = createModeUserPasswordCommandLine(SAVE_RECORD_MODE_COMMAND)
                .addArgument(ValidationUtil.toString(callId)).addArgument(
                        ValidationUtil.toString(pathToResult));
        execute(commandLine);
    }

    private void execute(CommandLine commandLine) throws IOException {
        Assert.notNull(pathToProcess);
        executor.setWatchdog(watchDog);
        executor.setProcessDestroyer(shutdownHookProcessDestroyer);
        executor.setStreamHandler(createStreamHandler());
        if (LOG.isDebugEnabled()) {
            LOG.debug("Executing " + commandLine);
        }
        executor.execute(commandLine, resultHandler);
    }

    private CommandLine createModeUserPasswordCommandLine(String mode) {
        Assert.hasLength(sensormUser);
        Assert.notNull(sensormPassword);
        return createCommandLine().addArgument(mode).addArgument(sensormUser);
    }

private CommandLine createCommandLine() {
    return new CommandLine(pathToProcess);
}

private ExecuteStreamHandler createStreamHandler() {
    OutputEventsHandler eventsHandler = new OutputEventsHandler(eventsQueue);
    SensormLogHandler errorLogHandler = new SensormLogHandler(LOG, Level.ERROR);
    return new PumpStreamHandler(eventsHandler, errorLogHandler);
}

public int waitFor() throws InterruptedException {
    resultHandler.waitFor();
    return resultHandler.getExitValue();
}