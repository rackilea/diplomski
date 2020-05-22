Thread errThread = new Thread(stderrprocessor);
errThread.setDaemon( true );
errThread.start();

Thread outThread = new Thread(stdoutprocessor);
outThread.setDaemon( true );
outThread.start();