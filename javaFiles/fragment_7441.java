import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.*;

public class TestClassExample {
    public static void main(String[] args) {
        String[][] data = new String[][]{
                {"class1", "TC_LOGIN"},
                {"class2", "TC_LOGIN"},
                {"class1", "TC_WORK"}
        };
        sample(transformToMap(data), Collections.emptyMap());
    }

    private static Map<String, List<String>> transformToMap(String[][] data) {
        Map<String, List<String>> map = new HashMap<>();
        for (String[] aData : data) {
            String key = aData[1];
            List<String> classes = map.computeIfAbsent(key, k -> new ArrayList<>());
            classes.add(aData[0]);
        }
        return map;
    }

    private static void sample(Map<String, List<String>> dbArr, Map<String, String> parameters) {

        //Create an instance on TestNG
        TestNG myTestNG = new TestNG();

        //Create an instance of XML Suite and assign a name for it.
        XmlSuite suite = new XmlSuite();
        suite.setName("App Automation Testing");
        suite.setParameters(parameters);
        dbArr.forEach((key, value) -> {
            XmlTest xmlTest = new XmlTest(suite);
            xmlTest.setName(key);
            value.forEach(eachValue -> {
                XmlClass xmlClass = new XmlClass(eachValue, false);
                xmlTest.getClasses().add(xmlClass);
            });
        });

        //Add the suite to the list of suites.
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        System.out.println(suite.toXml());

        //Set the list of Suites to the testNG object you created earlier.
        myTestNG.setXmlSuites(suites);
    }
}