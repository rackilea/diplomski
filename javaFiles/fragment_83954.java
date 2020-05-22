public static void main(String[] args) throws Exception {
        execCommons();
    }

    public static void execCommons() throws ExecuteException, IOException {
        CommandLine cmd = new CommandLine("cmd.exe ");
        cmd.addArgument("/c");
        String command = "mysqldump " + "-u" + "root" + " -P" + "3316" + " -h" + "localhost" + " -A >" + "\"G:\\test.sql \"";
        cmd.addArgument(command,false);
        new DefaultExecutor().execute(cmd);    
    }