import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

    public class TestngTestSuiteUsingXML {

        public static void main(String[] args) {

            List<String> files=new ArrayList<String>();
            files.add("/Users/test/testng/testng.xml");
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(files);
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            suites.add(suite);
            TestNG tng = new TestNG();
            tng.setXmlSuites(suites);
            tng.run();
        }

    }