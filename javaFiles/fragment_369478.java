class StoreLineLineMapper implements LineMapper<DomainObject> {
  private LineMapper<DomainObject> delegate;

  public DomainObject mapLine(java.lang.String line, int lineNumber) throws java.lang.Exception {
    DomainObject record = delegate.mapLine(line, lineNumber);
    record.setLineInfo(new LineInfo(line, lineNumber));
    return record;
  }
}