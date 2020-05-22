@Test
public void test() throws InterruptedException {
    //initialize the countDownLatch and set in on the processing class
    CountDownLatch countDownLatch = new CountDownLatch(1);
    messageProcessor.setCountDownLatch(countDownLatch);
    //sendthemessage
    sendSomeMessage();
    //wait for the processing method to call countdown()
    countDownLatch.await();
    verify();
}