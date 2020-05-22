String workingDir = "C:\\TEST\\";
ProcessBuilder builder = new ProcessBuilder(
    new String[] {"cmd.exe", "/C",workingDir+"game.exe"}
  );
builder.directory(new File(workingDir));
Process newProcess = builder.start();