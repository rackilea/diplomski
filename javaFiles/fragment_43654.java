@RunWith(PowerMockRunner.class)
@PrepareForTest({ProcessImageData.class, FileUtils.class})
public class ProcessImageDataTest {

    private File file = new File("imageFilePath");

    private ProcessImageData processImageData;
    @Mock
    private PrintWriter mockPrintWriter;
    @Mock
    private LineIterator lineIterator;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);

        processImageData = new ProcessImageData(file);
        PowerMockito.whenNew(PrintWriter.class)
            .withArguments(file)
            .thenReturn(mockPrintWriter);
        PowerMockito.mockStatic(FileUtils.class);
        PowerMockito.when(
            FileUtils.lineIterator(file, StandardCharsets.UTF_8.displayName())
        ).thenReturn(lineIterator);
        PowerMockito.when(lineIterator.hasNext()).thenReturn(true, true, false);
    }

    @Test
    public void testExecute() throws Exception {
        PowerMockito.when(lineIterator.nextLine()).thenReturn("Foo", "Bar");
        processImageData.execute();
        Mockito.verify(mockPrintWriter,  Mockito.times(1)).println("Foo");
        Mockito.verify(mockPrintWriter,  Mockito.times(1)).println("Bar");
    }
}