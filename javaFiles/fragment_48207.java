ExecutorService background = Executors.newSingleThreadExecutor();
Future<String> stdOutReader = background.submit(() -> readStream(stdOut));

String output = readStream(stdErr);
if (output.isEmpty()) {
    output = stdOutReader.get();
}

background.shutdown();

if (output.isEmpty()) {
    gpgResult = "Exit code: " + gpgProcess.waitFor();
} else {
    gpgResult = "Exit code: " + gpgProcess.waitFor() + "\n" + output;
}