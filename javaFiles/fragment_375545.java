import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CsvToXml {

    public static void main(String[] args) {
        File inputFile = new File("C:/Users/Admin/Desktop/data.csv");
        CSVParser inParser = null;
        Document newDoc = null;
        try {
            inParser = CSVParser.parse(inputFile, StandardCharsets.UTF_8,
                    CSVFormat.EXCEL.withHeader().withQuoteMode(QuoteMode.NON_NUMERIC));
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

            newDoc = domBuilder.newDocument();
            // Root element
            Element rootElement = newDoc.createElement("root");
            newDoc.appendChild(rootElement);
            List<CSVRecord> records = inParser.getRecords();
            for (String key : inParser.getHeaderMap().keySet()) {
                Element rowElement = newDoc.createElement("header");
                rootElement.appendChild(rowElement);
                rowElement.setTextContent(key);
                for (CSVRecord record : records) {
                    rowElement = newDoc.createElement("row");
                    rootElement.appendChild(rowElement);
                    rowElement.setTextContent(record.get(key));
                }
            }
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            aTransformer.setOutputProperty(OutputKeys.METHOD, "xml");
            aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            Source src = new DOMSource(newDoc);
            Result result = new StreamResult(new File("C:/Users/Admin/Desktop/data.xml"));

            aTransformer.transform(src, result);
            System.out.println("File creation successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inParser != null) {
                try {
                    inParser.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}