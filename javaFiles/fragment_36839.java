boolean isDebug() {
  for(String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
    if(arg.contains("jdwp=")) {
      return true;
    }
  }
  return false;
}