@Test
@OperateOnDeployment("my-service")
public void testMessageInTopic() throws Exception {
    // insert the message into the topic
    final TextMessage message = (TextMessage) consumer.receive(15000);
    // perform assertions after message received, not null, text, etc
}