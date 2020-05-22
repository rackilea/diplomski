public static void main(String[] args) throws Exception {
    String command = "/usr/local/bin/docker ps";
    shellCmd1(command);
}

public static void shellCmd1(String command) throws Exception {
    ProcessBuilder pb = new ProcessBuilder(command.split("\\s+"));
    pb.inheritIO();
    Process p = pb.start();
    p.waitFor();
}