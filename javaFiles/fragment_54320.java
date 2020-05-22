import org.xml.sax.SAXException;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class XmlReadWrite3 {
public static void main(String[] args) {

    // here you enter the path to your directory.
    // for example: Path workDir = Paths.get("c:\\workspace\\xml-files")

    Path workDir = Paths.get("path/to/dir"); // enter the path to your xml-dir
    // the if checks whether the directory truly exists
    if (!Files.notExists(workDir)) {
        // this part stores all files withn the directory in a list
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(workDir)) {
            for (Path path : directoryStream) {


                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(path.toString());

                    Element langs = doc.getDocumentElement();


                    Element filename = getElement(langs, "Filename");
                    Element beschreibung = getElement(langs, "Beschreibung");
                    Element name = getElement(langs, "Name");
                    Element ide = getElement(langs, "IDe");

                    System.out.println("Filename:      " + filename.getTextContent() + "\n" + "Beschreibung:  "
                            + beschreibung.getTextContent() + "\n" + "Ersteller:     " + name.getTextContent() + "\n"
                                 + "Pnummer: " + ide.getTextContent() + "\n\n");
                    } catch (ParserConfigurationException pce) {
                        pce.printStackTrace();
                    } catch (SAXException se) {
                        se.printStackTrace();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                         }
                 }
            } catch (Exception e) {
                System.out.println(e.getMessage())
                          }
        }
    }

    private static Element getElement(Element langs, String tag) {
        return (Element) langs.getElementsByTagName(tag).item(0);
    }
}