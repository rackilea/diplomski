import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class WriteXMLFile {

    public static void sendXml(String result, int operationN) throws Exception, IOException{
        String filepath = "file.xml";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        Node tonode=doc.getElementsByTagName("command").item(0);
        Element res = doc.createElement("result");
        res.setTextContent(result);
        tonode.appendChild(res);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result1 = new StreamResult(new File("file2.xml"));

            // Output to console for testing
             StreamResult result3 = new StreamResult(System.out);

            transformer.transform(source, result1);

            System.out.println("File saved!");
    }

    public static void main(String argv[]) {

      try {
          WriteXMLFile writeXMLFile=new WriteXMLFile();
          writeXMLFile.sendXml("hitest", 1);

      } catch (Exception pce) {
        pce.printStackTrace();
      } 
    }
}