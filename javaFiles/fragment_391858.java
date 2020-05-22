Collection<String> pids = new ArrayList<>();

ProcessBuilder p = new ProcessBuilder("netstat.exe", "-noa", "-p", "tcp");
p.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
Process netstat = p.start();

try (BufferedReader output =
    new BufferedReader(new InputStreamReader(netstat.getOutputStream()))) {

    String line;
    while ((line = output.readLine()) != null) {

        if (line.toUpperCase().contains("CLOSE_WAIT") &&
            line.contains(ip + ":443")) {

            String[] tokens = line.split("\\s+");
            String pid = tokens[4];
            if (!pid.equals("0")) {
                pids.add(pid);
            }
        }
    }
}

if (netstat.waitFor() != 0) {
    throw new IOException("netstat command failed");
}

p.inheritIO();
for (String pid : pids) {
    Process taskkill = p.command("taskkill.exe", "/pid", pid).start();
    taskkill.waitFor();
}