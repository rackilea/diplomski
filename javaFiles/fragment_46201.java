public static void main(String[] args) throws IOException, InterruptedException {

    // this is your script in a string
    String script = "#!/bin/bash\n\necho \"Hello World\"\n echo $val";

    List<String> commandList = new ArrayList<>();
    commandList.add("/bin/bash");

    ProcessBuilder builder = new ProcessBuilder(commandList);
    builder.environment().put("val", "42");
    builder.redirectErrorStream(true);
    Process shell = builder.start();

    // Send your script to the input of the shell, something
    // like doing cat script.sh | bash in the terminal
    try(OutputStream commands = shell.getOutputStream()) {
        commands.write(script.getBytes());
    }

    // read the outcome
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(shell.getInputStream()))) {
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    // check the exit code
    int exitCode = shell.waitFor();
    System.out.println("EXIT CODE: " + exitCode);
}