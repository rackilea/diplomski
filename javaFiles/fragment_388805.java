import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;



public class Demo {

    public static void main(String[] args) {

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try{
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(
                    System.out);           
            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeStartElement("cars");
            xmlStreamWriter.writeAttribute("type", "formula one");
            xmlStreamWriter.writeCharacters("");
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        }catch(Exception  e){
            e.printStackTrace();
        }

    }
}