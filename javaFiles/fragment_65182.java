InputStream stdout = new BufferedInputStream(proc.getInputStream());
FileOutputStream stdoutFile = new FileOutputStream("stdout.txt");
ByteStreams.copy(stdout, stdoutFile);

InputStream stderr = new BufferedInputStream(proc.getErrorStream());
FileOutputStream stderrFile = new FileOutputStream("stderr.txt");
ByteStreams.copy(stderr, stderrFile);

stdout.close();
stderr.close();
stdoutFile.close();
stderrFile.close();