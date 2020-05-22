@Override
public Void answer(InvocationOnMock invocation) throws Throwable {
    invocation.callRealMethod();
    this.latch.countDown();
    return null;
}