import java.io.StringReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public static void testStaxParser() {
        String xmlSource = "<root>" +
                        "<head>" +
                            "<version>1.1</version>" +
                        "</head>" +
                        "<body>" +
                            "<ele1>value</ele1>" +
                            "<ele2>" +
                                "<suvEle1>value</suvEle1>" +
                            "</ele2>" +
                            "<ele3>" +
                                "<suvEle1>value</suvEle1>" +
                            "</ele3>" +
                        "</body>" +
                    "</root>";      

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = 
                factory.createXMLStreamReader(
                        new StringReader(xmlSource));

            while(reader.hasNext()){
                int parseEvent = reader.next();

                if (parseEvent == XMLStreamConstants.START_ELEMENT){ 
                    if ("body".equals(reader.getLocalName())) {
                         System.out.println("Start of body element.");
                         processElements(reader);
                         return;
                   }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }

    }

public static void processElements(XMLStreamReader reader) throws XMLStreamException {  
        do {
            int parseEvent = reader.next();

            switch(parseEvent){
                case XMLStreamConstants.START_ELEMENT: 
                    System.out.println("Start of element " + reader.getLocalName());                  
                  break;

                case XMLStreamConstants.CHARACTERS:
                    System.out.println("Element content is " + reader.getText().trim());

                    break;

                case XMLStreamConstants.END_ELEMENT:
                    if ("body".equals(reader.getLocalName())) {
                        System.out.println("End of body element.");
                        return;
                    }

                    System.out.println("End of element " + reader.getLocalName());
                  break;
            }           
        } while (reader.hasNext());
    }