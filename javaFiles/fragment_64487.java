class Resource {
  private String data;
  private Instant creationTimestamp;

  public Resource(String someData) {
    this.data = someData;
    this.creationTimestamp = Instant.now();
  }
}