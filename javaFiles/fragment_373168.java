import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ConfigImporter
{
    private static String cfgXml = "<configuration> <config name='name1' type='main' format='xyz-D' size='1' scale='2' required='no'/> <config name='name2' type='sub' format='xyz-E' size='12' scale='5' required='no'/> <config name='name3' type='last' format='xyz-C' size='2' scale='1' required='no'/> <config name='name4' type='first' format='xyz-S' size='16' scale='3' required='no'/> <config name='name5' type='main' format='xyz-S' size='17' scale='2' required='no'/> <config name='name6' type='main' format='xyz-S' size='18' scale='2' required='no'/> <config name='name7' type='first' format='xyz-S' size='23' scale='4' required='no'/> <config name='name8' type='last' format='xyz-S' size='45' scale='2' required='no'/> <config name='name9' type='sub' format='xyz-s' size='39' scale='15' required='no'/> </configuration>";

    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(cfgXml)));

            // optional, but recommended
            // read this -
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("config");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element eElement = (Element) nNode;

                    Config c = new Config();

                    c.name = eElement.getAttribute("name");
                    c.type = eElement.getAttribute("type");
                    c.format = eElement.getAttribute("format");
                    c.size = Integer.valueOf(eElement.getAttribute("size"));
                    c.scale = Integer.valueOf(eElement.getAttribute("scale"));
                    String attribute = eElement.getAttribute("required");

                    c.required = Boolean.valueOf("Yes".equalsIgnoreCase(attribute) ? true : false);

                    System.out.println("Imported config : " + c);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static class Config
    {
        @Override
        public String toString()
        {
            return "Config [name=" + name + ", type=" + type + ", format=" + format + ", size=" + size + ", scale=" + scale + ", required="
                    + required + "]";
        }

        public String name;
        public String type;
        public String format;
        public int size;
        public int scale;
        public boolean required;
    }
}