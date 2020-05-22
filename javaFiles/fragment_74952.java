@Mock
  private ReportSenderRunnable reportSenderRunnable;

  @Mock
  private LPLogCompressor compressor;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test(timeout = 1000)
  public void testJobNoException() throws InterruptedException, IOException {
    final ReportSender reportSender = spy(new ReportSender());
    doReturn(compressor).when(reportSender).getLpLogCompressor();
    when(compressor.compress()).thenReturn("nothing");
    reportSender.sendAndReturnStatus();
    Thread.sleep(10);
    assertEquals("Job must be completed successfully", ReportStatus.DONE,
                 reportSender.getCurrentStatus());
  }

  @Test(timeout = 1000)
  public void testJobWithIllegalStateException() throws Exception {
    final ReportSender reportSender = spy(new ReportSender());
    doReturn(compressor).when(reportSender).getLpLogCompressor();
    doThrow(IllegalStateException.class).when(compressor).compress();
    reportSender.sendAndReturnStatus();
    Thread.sleep(10);
    assertEquals("Job must failed during compression", ReportStatus.EXCEPTION_IN_COMPRESSION,
                 reportSender.getCurrentStatus());
  }