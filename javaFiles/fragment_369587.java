@RunWith(AllTests.class)
public class mainTester {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();

        for(Class<?> klass : CsvParser.readCSV()) {
            suite.addTest(new junit.framework.JUnit4TestAdapter(klass));
        }

        return suite;
    }

}