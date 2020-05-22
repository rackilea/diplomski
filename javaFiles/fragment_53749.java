import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.NamedNodeMap;

public class Test {
    private static final String FIVE_DAY_FORECAST_URL = 
        "https://api.openweathermap.org/data/2.5/forecast?q=Denver&appid=8984d739fa91d7031fff0e84a3d2c520&mode=xml&units=imperial";

    private static final String TIME_ELEM = "time";
    private static final String TEMPERATURE_ELEM = "temperature";
    private static final String TIME_FROM_ATTR = "from";
    private static final String TIME_TO_ATTR = "to";
    private static final String TEMPERATURE_MIN_ATTR = "min";
    private static final String TEMPERATURE_MAX_ATTR = "max";

    private static void getWeatherForcast() {
        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(FIVE_DAY_FORECAST_URL);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(TIME_ELEM);
            for (int i = 0; i < nodeList.getLength(); i++) {
                final Node node = nodeList.item(i);
                final NamedNodeMap namedNodeMap = node.getAttributes();
                final Node fromAttr = namedNodeMap.getNamedItem(TIME_FROM_ATTR);
                final Node toAttr = namedNodeMap.getNamedItem(TIME_TO_ATTR);
                System.out.println("Time: " + fromAttr + " " + toAttr);
                final NodeList timeChildren = node.getChildNodes();
                for (int j = 0; j < timeChildren.getLength(); j++) {
                    final Node timeChild = timeChildren.item(j);
                    if (TEMPERATURE_ELEM.equals(timeChild.getNodeName())) {
                        final NamedNodeMap temperatureAttrMap = timeChild.getAttributes();
                        final String minTemp = temperatureAttrMap.getNamedItem(TEMPERATURE_MIN_ATTR).getNodeValue();
                        final String maxTemp = temperatureAttrMap.getNamedItem(TEMPERATURE_MAX_ATTR).getNodeValue();
                        System.out.println("min: " + minTemp + " max: " + maxTemp);
                    }
                }

            }
        } catch (ParserConfigurationException | IOException ex) {
            ex.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getWeatherForcast();
    }
}