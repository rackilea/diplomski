public enum SoaJSONLoggerProvider implements SoaJSONLogger {
  INSTANCE;
  private final SoaJSONLogger delegatee = new SoaJSONLoggerImp();

  @Override
  public void trace(String xmlLog) {
    delegatee.trace(xmlLog);
  }