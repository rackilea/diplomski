@Test
    public void test() throws InterruptedException {

    PowerMockito.mockStatic(Thread.class);
    PowerMockito.doThrow(new InterruptedException()).when(Thread.class);
    Thread.sleep(1); //This is still setting up the mock, not actually invoking the method.
    }