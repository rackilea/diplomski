ProcessBuilder p = new ProcessBuilder("netstat.exe", "-noa", "-p", "tcp");
p.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
Process netstat = p.start();

try (BufferedReader output =
    new BufferedReader(new InputStreamReader(netstat.getOutputStream()))) {

    final ProcessBuilder taskkill = new ProcessBuilder().inheritIO();

    output.lines()
        .filter(line -> line.toUpperCase().contains("CLOSE_WAIT") &&
            line.contains(ip + ":443"))
        .map(line -> line.split("\\s+")[4])
        .filter(pid -> !pid.equals("0"))
        .forEach(pid ->
            taskkill.command("taskkill.exe", "/pid", pid).start());
}

if (netstat.waitFor() != 0) {
    throw new IOException("netstat command failed");
}