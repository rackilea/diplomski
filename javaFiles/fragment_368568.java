public class MyDoFn extends DoFn<String, PubsubMessage>() {
  @ProcessElement
  public void processElement(ProcessContext c) {
    c.output(new PubsubMessage(c.element().getBytes(), null));
  }
}