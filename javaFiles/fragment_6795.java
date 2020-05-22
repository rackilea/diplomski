testObject.doSomething();
EasyMock.expectLastCall().andAnswer(new IAnswer<Void>(){
  @Override
  public Void answer() throws Throwable {
    latch.countDown();
    return null;
  }}).times(2);

EasyMock.replay(testObject);
easyMockTest.test();
easyMockTest.test();
easyMockTest.test();

latch.await(1, TimeUnit.SECONDS);

EasyMock.verify(testObject);