public enum EventAction {
  SDCARD_MOUNTED(25, "External SDCard was mounted");
  private final int code;
  private final String message;
  private EventAction(int code, String message) {
    this.code = code;
    this.message = message;
  }
  @Override
  public String toString() { return message; }
  public int getCode() { return code; }
}