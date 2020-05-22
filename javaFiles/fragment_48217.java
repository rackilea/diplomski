@RunWith(value = Parameterized.class)
public class JunitTest {

     private String filename;

     public JunitTest(String filename) {
        this.filename= filename;
     }

     @Parameters
     public static Collection<Object[]> data() {
       Object[][] data = new Object[][] { { "file1.xml" }, { "file2.xml" } };
       return Arrays.asList(data);
     }

     @Test
     public void Test() {
       System.out.println("Test name:" + filename);
     }


}