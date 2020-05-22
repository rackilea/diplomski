@Test
public void test() {
    byte[] expected = "example".getBytes();

    HttpRequest.BodyPublisher bodyPublisher =
            HttpRequest.BodyPublishers.ofByteArray(expected);

    FlowSubscriber<ByteBuffer> flowSubscriber = new FlowSubscriber<>();
    bodyPublisher.subscribe(flowSubscriber);

    byte[] actual = flowSubscriber.getBodyItems().get(0).array();

    Assert.assertArrayEquals(expected, actual);
}