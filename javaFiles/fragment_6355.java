String cmd = "wmic cpu get LoadPercentage";
    ProcessBuilder pb = new ProcessBuilder(cmd);
    pb.redirectErrorStream(true);
    Process p = pb.start();
    BufferedReader stdin = new BufferedReader(
                          new InputStreamReader(p.getInputStream()));
    StringBuilder commandOutput = new StringBuilder();
    String line;
    while ((line = stdin.readLine()) != null) {
      commandOutput.append(line);
    }
    int exitValue = -1;
    try {
     exitValue = p.waitFor();
    } catch (InterruptedException e) {
    // do something here   
    }