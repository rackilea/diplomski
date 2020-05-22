import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {
    public static List<TestBus> testBuses = new ArrayList<>();

    public static void main(String argv[]) {

        try {
            File fXmlFile = new File("D:\\ECLIPSE-WORKSPACE\\demo-xml-project\\src\\main\\resources\\testbus.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList testBusNodeList = doc.getElementsByTagName("testbus");

            for (int parameter = 0; parameter < testBusNodeList.getLength(); parameter++) {
                TestBus testBus = new TestBus();
                Node node = testBusNodeList.item(parameter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String index = eElement.getElementsByTagName("index").item(0).getTextContent();
                    String tb_name = eElement.getElementsByTagName("tb_name").item(0).getTextContent();
                    NodeList bitf_name = eElement.getElementsByTagName("bitf_name");
                    List<String> bitf_namesList = new ArrayList<>();
                    IntStream.range(0, bitf_name.getLength()).forEach(bName -> {
                        bitf_namesList.add(bitf_name.item(bName).getTextContent());
                    });
                    testBus.setIndex(index);
                    testBus.setTb_name(tb_name);
                    testBus.setBitf_names(bitf_namesList);

                    testBuses.add(testBus);
                }
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!  Exception while reading xml file :" + e.getMessage());
        }

        testBuses.forEach(bus -> System.out.println(bus));  // in single line
        System.out.println("###################################################");

        // using getters
        testBuses.forEach(bus -> {
            System.out.println("index = " + bus.getIndex());
            System.out.println("tb_name = " + bus.getTb_name());
            System.out.println("bitf_names = " + bus.getBitf_names());
            System.out.println("#####################################################");
        });
    }
}