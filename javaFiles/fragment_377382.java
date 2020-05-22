public class MyWriterTest {
  @Rule public final TemporaryFolder folder = new TemporaryFolder();
  private File output;
  private MyWriter writer;

  @Before
  public void createMyWriter() {
    output = folder.newFile();
    writer = new MyWriter(output);
  }

  ...
}