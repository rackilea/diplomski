@Test
public void nominalClose() {
    Closeable closeable = new MyCloseable();
    Assert.assertFalse(closeable.isClosed());
    MyClass.close(closeable);    // call to the method you want to test
    Assert.assertTrue(closeable.isClosed());
}

@Test(expected = RuntimeException.class) 
public void ioExceptionClose() {
    Closeable closeable = new Closeable(){
        @Override
        public void close() {
            throw new IOException("test IO");
        }
    };
    MyClass.close(closeable);    // call should send a RuntimeException
}

// TODO: add more tests? Null? not IOException?

private static class MyCloseable implements Closeable {
    private boolean closed = false;
    @Overrive
    public void close() {
        closed = true;
    }
    public boolean isClosed() {
        return closed;
    }
}