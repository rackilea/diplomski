@Test(expected = FTPException.class)
public void ConnectFailsIfExceptionOnClientConnect() throws FTPException {
    // setup
    downloadInitialFileTasklet.setHostName("hostname");
    when(mockFtpClient).connect(any(String.class)).doThrow(new SocketException());

    // verify -- if something else throws an FTP exception later then the verify
    // statements should fail the test because either connect was not called 
    // because or login was
    verify(mockFtpClient).connect(any(String.class));
    verify(mockFtpClient, never()).login(any(String.class), any(String.class));

    downloadInitialFileTasklet.connect();
}