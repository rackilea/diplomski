private volatile Exception exeption;

@Override
public Void answer(InvocationOnMock invocation) throws Throwable {
    try {
        invocation.callRealMethod();
    } 
    catch (RuntimeException e) {
        this.exception = e;
        throw e;
    }
    finally {
        this.latch.countDown();
    }
    return null;
}

public Exception getException() {
    return this.exception;
}