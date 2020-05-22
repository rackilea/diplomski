public static void main() {
    String absolutePath = "/home/marievi/Downloads/small.mp4";
    String[] command = { "ffmpeg", "-i", absolutePath };
    ExecuteShellCommand obj = new ExecuteShellCommand();
    String output = obj.executeCommand(command);
    System.out.println(output);
}

public String executeCommand(String[] command) {

    StringBuilder output = new StringBuilder();

    try {
        ProcessBuilder builder = new ProcessBuilder(command);
        // Share standard input/output/error descriptors with Java process...
        builder.inheritIO();
        // ... except standard output, so we can read it with getInputStream().
        builder.redirectOutput(ProcessBuilder.Redirect.PIPE);

        Process p = builder.start();

        try (BufferedReader reader =
            new BufferedReader(new InputStreamReader(p.getInputStream()))) {

            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        }

        p.waitFor();

    } catch (IOException | InterruptedException e) {
        // Process failed;  do not attempt to continue!
        throw new RuntimeException(e);
    }

    return output.toString();
}