CommandLine command = new CommandLine(/bin/bash);
command.addArgument(ScriptName);
command.addArgument(Param1);

if (Param2== null || Param2.trim().length() == 0) {
    command.addArgument("\"\"", false);
} else {
    command.addArgument(Param2);
}

command.addArgument(Param3);