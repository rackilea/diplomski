public static void main(String[] args) throws IOException, InterruptedException {

    // Your script
    String script = "#!/usr/bin/env Rscript\n" +
            "\n" +
            "sayHello <- function() {\n" +
            "    print('hello')\n" +
            "}\n" +
            "\n" +
            "sayHello()\n";

    // create a temp file and write your script to it
    File tempScript = File.createTempFile("test_r_scripts_", "");
    try(OutputStream output = new FileOutputStream(tempScript)) {
        output.write(script.getBytes());
    }

    // build the process object and start it
    List<String> commandList = new ArrayList<>();
    commandList.add("/usr/bin/Rscript");
    commandList.add(tempScript.getAbsolutePath());
    ProcessBuilder builder = new ProcessBuilder(commandList);
    builder.redirectErrorStream(true);
    Process shell = builder.start();

    // read the output and show it
    try(BufferedReader reader = new BufferedReader(
            new InputStreamReader(shell.getInputStream()))) {
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    // wait for the process to finish
    int exitCode = shell.waitFor();

    // delete your temp file
    tempScript.delete();

    // check the exit code (exit code = 0 usually means "executed ok")
    System.out.println("EXIT CODE: " + exitCode);
}