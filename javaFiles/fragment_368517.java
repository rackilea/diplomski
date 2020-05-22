import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class UpdateXML {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = f.newDocumentBuilder();
            Document doc = b.parse(new File("Data.xml"));

            XPath xPath = XPathFactory.newInstance().newXPath();
            Node startDateNode = (Node) xPath.compile("/data/startdate").evaluate(doc, XPathConstants.NODE);
            startDateNode.setTextContent(addMonthTo(startDateNode.getTextContent()));

            xPath = XPathFactory.newInstance().newXPath();
            Node endDateNode = (Node) xPath.compile("/data/enddate").evaluate(doc, XPathConstants.NODE);
            endDateNode.setTextContent(addMonthTo(endDateNode.getTextContent()));

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult(new File("AData.xml"));
            tf.transform(domSource, sr);
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException | DOMException | TransformerFactoryConfigurationError | IllegalArgumentException | TransformerException exp) {
            exp.printStackTrace();
        }
    }

    public static String addMonthTo(String value) {

        String patterns[] = {"M/d/yyyy", "M/dd/yyyy", "MM/d/yyyy", "MM/dd/yyyy"};

        LocalDate ld = null;
        for (String pattern : patterns) {
            try {
                ld = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
                break;
            } catch (DateTimeParseException exp) {
            }
        }

        if (ld == null) {
            throw new DateTimeParseException("Could not parse " + value + " with available patterns", value, -1);
        }

        ld = ld.plusMonths(1);
        return DateTimeFormatter.ofPattern("MM/dd/yyyy").format(ld);

    }

}