public static void main(String[] args) {
    // String command = "/usr/bin/sleep 5";
    List<String> command = new ArrayList<String>();
    command.add("c:/cygwin/bin/sleep");
    command.add("5");
    ProcessBuilder pb = new ProcessBuilder(command);
    BufferedReader is = null;
    try {
        System.out.println("Starting command " + command);
        Process p = pb.start();

        int ret = p.waitFor();
        is = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = is.readLine()) != null) {
            System.out.println(line);
        }
        if (ret == 0) {
            System.out.println("Command has completed.");
            System.exit(ret);
        } else {
            System.out.println("Command completed with return code " + ret);
            System.exit(ret);
        }
    } catch (Exception e) {
        System.out.println("Caught Exception " + e.getMessage()
                + " running command " + command);
        e.printStackTrace();
    } finally {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
    System.out.println("COMMAND FAILED");
    System.exit(1);
}