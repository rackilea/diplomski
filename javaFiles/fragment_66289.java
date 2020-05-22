String commandString;

if ( new File(env1 + "/my_command").isFile() ) {
  commandString = env1 + "/my_command";
} else
if ( new File(env2 + "/my_command").isFile() ) {
  commandString = env2 + "/my_command";
}

ProcessBuilder pb = new ProcessBuilder(commandString, file, output);