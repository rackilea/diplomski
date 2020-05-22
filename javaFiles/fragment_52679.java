@Test
public void testStartService() throws Exception {
    //Setup
    final Logger mockedLogger = mock(Logger.class);

    final MedSlaveImpl service = new MedSlaveImpl() {
        @Override
        Logger getLogger() {
            return mockedLogger;
        }
    }

    // When
    service.enterMode();

    // Then
    verify(mockedLogger).info("muting the Manager");
}