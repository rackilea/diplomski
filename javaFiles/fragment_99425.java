@Test
public void test_onStart_throw_IO_exceptioon() throws Exception {
    ZConnectionService zConnectionService = new ZConnectionService();
    ZConnection mockedZConnection = mock(ZConnection.class);
    doNothing().when(mockedZConnection).connect();

    zConnectionService.initConnection(mockedZConnection);

    // Wait for the Thread to complete
    while(zConnectionService.mThread.isAlive()) {
        Thread.sleep(100);
    }
    verify(mockedZConnection, times(1)).connect();
}