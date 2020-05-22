String[] command = new String[]{"curl", "http://localhost:8080/auth/login",
         "-H", "Origin:   http://localhost:9000", "--data-binary",
         "{\"username\":\"policy-engine\",\"password\":\"openstack\"}", "--compressed"};


private String executeCommand(String... command) {
  ProcessBuilder builder = new ProcessBuilder(command);
  builder.redirectOutput(new File("curloutput.txt"));
  p.start();
}