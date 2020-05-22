class MyDoFn extends DoFn<X, Y> {
  private transient Connection jdbc;

  @Setup
  public void setup(Context c) {
    jdbc = // Create connection
  }

  @ProcessElement
  public void processElement(ProcessContext c) {
    // query database
  }

  @Teardown
  public void tearDown(Context c) {
    // close connection
  }
}