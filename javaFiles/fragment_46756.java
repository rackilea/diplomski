package be.duo.stax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxExample {

    public void getXml() {
        InputStream is = null;
        try {
            is = new FileInputStream("c:\\dev\\sample.xml");

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(is);

            parse(reader, 0);

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch(IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }

    }

    private void parse(XMLStreamReader reader, int depth) throws XMLStreamException {
        while(true) {
            if(reader.hasNext()) {
                switch(reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    writeBeginTag(reader.getLocalName(), depth);
                    parse(reader, depth+1);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    writeEndTag(reader.getLocalName(), depth-1);
                    return;
                }
            }
        }
    }

    private void writeBeginTag(String tag, int depth) {
        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("<" + tag + ">");
    }

    private void writeEndTag(String tag, int depth) {
        for(int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        System.out.println("</" + tag + ">");
    }

    public static void main(String[] args) {
        StaxExample app = new StaxExample();
        app.getXml();
    }

}