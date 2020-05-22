String output;
try (BufferedReader stdOut = new BufferedReader(new InputStreamReader(gpgProcess.getInputStream()))) {
    output = readStream(stdOut);
}

if (output.isEmpty()) {
    gpgResult = "Exit code: " + gpgProcess.waitFor();
} else {
    gpgResult = "Exit code: " + gpgProcess.waitFor() + "\n" + output;
}