public static class FakeKvPair extends DoFn<String, KV<String, String>> {
  @ProcessElement
  public void processElement(ProcessContext c) {
    c.output(KV.of("", c.element()));
  }
}