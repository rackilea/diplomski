import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileDemo {

    // main method
    public static void main(String[] args) {

        File f = null;
        try {
            // create new file
            String root = "C:\\temp";
            f = new File(root);

            //shall accept all files in directories and subdirectories
            List<File> files = (List<File>) FileUtils.listFiles(f, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

            ArrayList<String> issn_valueLst = new ArrayList<>();

            for (File fXmlFile : files) {
                // prints filename and directory name
                if(accept(fXmlFile.getName(), ".xml")){
                DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                doc.getDocumentElement().normalize();
                NodeList nList2=doc.getElementsByTagName("CE:DOI");
                if(nList2.getLength()>=1)
                {
                     for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
                         Node nNode4 = nList2.item(temp2);

                         if (nNode4.getNodeType() == Node.ELEMENT_NODE) 
                         {
                            Element eElement1 = (Element) nNode4;
                            issn_valueLst.add(eElement1.getTextContent()+"-"+fXmlFile.getAbsolutePath());
                       } 
                               }
                  }
                }
            }
           // }
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }


    public static boolean accept( String name, String str) {
        return name.toLowerCase().endsWith(str.toLowerCase());
    }
}