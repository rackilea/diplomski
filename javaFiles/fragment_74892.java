@Test
public void testSomeMethod() throws InterruptedException {
    FooClass fooClassMock = Mockito.mock(FooClass.class);
    Thread thread = new MyThread(fooClassMock);

    new ForTest().methodToTest(thread);

    thread.join();

    Mockito.verify(fooClassMock).bar();
}