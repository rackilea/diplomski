import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConfigTest {

    private String xmlFile;

    public ConfigTest(String xmlFile) {
        this.xmlFile= xmlFile;
    }

    @Test
    public void testXml() throws Exception {
        System.out.println(xmlFile);
    }

    @Parameters
    public static Collection<String> data()  throws Exception{
        String file1 = new String(Files.readAllBytes(Paths.get(ConfigTest.class.getResource("config1.xml").toURI())));
        String file2 = new String(Files.readAllBytes(Paths.get(ConfigTest.class.getResource("config2.xml").toURI())));

        Collection<String> data = new ArrayList<String>();
        data.add(file1);
        data.add(file2);
        return data;

    }

}