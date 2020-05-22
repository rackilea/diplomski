// this test still fails, but. ..
public class MainTest {
private final InputStream testInputStream = new ByteArrayInputStream("2\n3\n".getBytes());
    private final ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
    private PrintStream initialOutputStream = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(testOutputStream));
    }

    @After
    public void restoreDefaultStreams() {
        System.setOut(initialOutputStream);
        System.out.println("Test initial output stream");
    }

    @Test
    public void fetchesTextFromInput() {
        Scanner scanner = new Scanner(testInputStream);
        Main main = new Main(scanner);
        main.process();
        final String actual = testOutputStream.toString();
        Assert.assertEquals("Input dividend: Input divisor: 2\n3", actual);
    }
}