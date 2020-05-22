CommandLine command = new CommandLine("/bin/sh");
    command.addArguments(new String[] {
            "-c",
            "echo 'test'"
    },false);
    new DefaultExecutor().execute(command);