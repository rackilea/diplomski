@Test
public void testGetPrintJobNameBeforeFourPM() {
    PrintProcessor concretePrintProcessor = new PrintProcessor();
    PrintProcessor printProcessor = spy(concretePrintProcessor);
    doReturn(true).when(printProcessor).isBeforeFourPM();

    String printJobName = printProcessor.getPrintJobName(Shipper.X);

    assertEquals("XNCRMNCF", printJobName);
}