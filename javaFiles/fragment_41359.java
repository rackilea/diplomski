class SCDynamicStore {
  public native String copyComputerName();
  static {
    System.loadLibrary("SCDynamicStore");
  }
}

class HostnameSC {
  public static void
  main(String[] args) {
    SCDynamicStore store = new SCDynamicStore();
    String computerName = store.copyComputerName();
    System.out.format("computer name: %s\n", computerName);
  }
}