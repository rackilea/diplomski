@Test(expected = Error.class)
public void testError() {
    byte[] memoryRequiredByJUnitHandler = new byte[100_000];
    try {
        outOfMemoryError.throwError();
    } catch (Throwable t) {
        // free enough heap memory so JUnit can handle exception
        memoryRequiredByJUnitHandler = null;
        throw t;
    }
}