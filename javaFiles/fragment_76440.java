@Test
public void shouldConsumeMessageWhenMessageIsProduced() {
    final Message expectedMessage = new Message("test");

    CountDownLatch messageReceived = new CountDownLatch(1);

    //consumer will poll every 1 second for a message
    consumer.poll(actualMessage -> {
      assertThat(actualMessage, is(expectedMessage));
      messageReceived.countDown();
    }

    producer.sendSynchronously(expectedMessage);

    //wait until the message is received, but not more than one second
    //await returns false if it reaches the timeout
    assertTrue(messageReceived.await(1, SECONDS));
}