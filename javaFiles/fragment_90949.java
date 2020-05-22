public RenameKeyTransformation implements Transformation {
  private final renameTo;
  public RenameKeyTransformation(String renameTo) {
    this.renameTo = checkNotNull(renameTo);
  }

  public Entry<String, String> apply(Entry<String, String> e) {
    return Maps.immutableEntry(renameTo, e.getValue());
  }
}