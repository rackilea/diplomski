try {
  ProcessBuilder pb = new ProcessBuilder(script, subject, message);
  pb.redirectErrorStream(true);
  pb.redirectOutput(new File("/dev/null"));
  Process process = pb.start();
  process.waitFor();
}
catch(Exception e) {
  LOGGER.error("Exception occured while invoking the message report script");
}