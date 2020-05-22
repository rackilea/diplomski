package codegen;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class GenCode {
    public static void main(String[] args) throws XMLStreamException, IOException {
        URL xmlFile = GenCode.class.getResource("Friends.xml");
        XMLInputFactory inFactory = XMLInputFactory.newFactory();
        XMLStreamReader reader = inFactory.createXMLStreamReader(xmlFile.openStream());

        try (FileWriter out = new FileWriter("generated/codegen/Friends.java")) {
            out.write("package codegen;\n");
            out.write("\n");
            out.write("public enum Friends {\n");

            String friendName = null;
            boolean inAge = false;
            String sep = "\t";
            while (reader.hasNext()) {
                switch (reader.next()) {
                    case XMLStreamReader.START_ELEMENT:
                        if (reader.getLocalName().equals("friend"))
                            friendName = reader.getAttributeValue(null, "name");
                        if (reader.getLocalName().equals("age"))
                            inAge = true;
                        break;
                    case XMLStreamReader.CHARACTERS:
                        if (inAge) {
                            out.write(sep + friendName + "_" + reader.getText());
                            sep = ",\n\t";
                        }
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if (reader.getLocalName().equals("age"))
                            inAge = false;
                        break;
                }

            }
            out.write("\n}");
        }
    }
}