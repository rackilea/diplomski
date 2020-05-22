String cmd = "#!/bin/sh\ntop -n1 -b > " + path + "output";
    File shellCmd = new File(path + "topscript.sh");
    PrintWriter writer = new PrintWriter(shellCmd);
    writer.write(cmd);
    writer.flush();
    Runtime.getRuntime().exec("chmod +x " + shellCmd.getAbsolutePath());

    ProcessBuilder pb = new ProcessBuilder(shellCmd.getAbsolutePath());
    Map<String, String> enviornments = pb.environment();
    enviornments.put("TERM", "xterm-256color");
    Process process = pb.start();

    BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader errorStreamReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
    String str = inputStreamReader.readLine();
    System.out.println(str);
    System.out.println(errorStreamReader.readLine());