CommandLine cmdLine = new CommandLine(yourExecutable);
DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

Executor executor = new DefaultExecutor();
executor.setStreamHandler(new YourPumpStreamHandler());
executor.execute(cmdLine, resultHandler);
// until waitFor returns, the process is running and events can be generated
int exitValue = resultHandler.waitFor();