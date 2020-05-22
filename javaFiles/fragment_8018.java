@RunWith(value = Parameterized.class)
public class AllTests {
  private String text;
  private Properties props;

  public AllTests(String text) {
    this.text = text;
    props = new Properties();
    try {
      // load a properties file
      props.load(new FileInputStream(text));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  @Parameters
  public static List<String[]> data() {
    String[][] data = new String[][] { { "test.properties" } };
    return Arrays.asList(data);
  }

  @Test
  public void test() {
    System.out.println(text);
  }
}