import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

 import javax.xml.parsers.DocumentBuilder;  
 import javax.xml.parsers.DocumentBuilderFactory;  
 import org.w3c.dom.Document;  
 import org.w3c.dom.Node;  
 import org.w3c.dom.NodeList;  



public class RecDOMP {


public static void main(String[] args) throws Exception{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        dbf.setValidating(false); 
        DocumentBuilder db = dbf.newDocumentBuilder();   

// replace following  path with your input xml path  
         Document doc = db.parse(new FileInputStream(new File  ("D:\\ambuj\\ATT\\apip\\APIP_New.xml")));  

// replace following  path with your output xml path 
         File OutputDOM = new File("D:\\ambuj\\ATT\\apip\\outapip1.txt");
            FileOutputStream fostream = new FileOutputStream(OutputDOM);
            OutputStreamWriter oswriter = new OutputStreamWriter (fostream);
            BufferedWriter bwriter = new BufferedWriter(oswriter);

            // if file doesnt exists, then create it
            if (!OutputDOM.exists()) {
                OutputDOM.createNewFile();}


            visitRecursively(doc,bwriter);
            bwriter.close(); oswriter.close(); fostream.close();

            System.out.println("Done");
}
public static void visitRecursively(Node node, BufferedWriter bw) throws IOException{  

             // get all child nodes  
         NodeList list = node.getChildNodes();                                  
         for (int i=0; i<list.getLength(); i++) {          
                 // get child node              
       Node childNode = list.item(i);  
       if (childNode.getNodeType() == Node.TEXT_NODE)
       {
   //System.out.println("Found Node: " + childNode.getNodeName()           
    //   + " - with value: " + childNode.getNodeValue()+" Node type:"+childNode.getNodeType()); 

   String nodeValue= childNode.getNodeValue();
   nodeValue=nodeValue.replace("\n","").replaceAll("\\s","");
   if (!nodeValue.isEmpty())
   {
       System.out.println(nodeValue);
       bw.write(nodeValue);
       bw.newLine();
   }
       }
       visitRecursively(childNode,bw);  

            }         

     }  

}