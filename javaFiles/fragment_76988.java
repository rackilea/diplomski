CommandLine cmdLine = CommandLine.parse(command);

for (String comm : cmd)
{
    cmdLine.addArgument(comm);
}

DefaultExecutor exec = new DefaultExecutor();
exec.setExitValue(0);
exec.setWorkingDirectory(new File(codeDir));
exitCode = exec.execute(cmdLine);