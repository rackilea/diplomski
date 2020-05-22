import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XmlApp {
    public static void main(String[] args) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        Application app = new Application();
        app.setEntry(map);

        // xml output format
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        System.out.println(xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(app));
    }
}

@JacksonXmlRootElement(localName = "headers")
@JsonSerialize(using = ApplicationJsonSerializer.class)
class Application {

    private Map<String, Object> entry;

    public Map<String, Object> getEntry() {
        return Collections.unmodifiableMap(entry);
    }

    public void setEntry(Map<String, Object> entry) {
        this.entry = entry;
    }
}

class ApplicationJsonSerializer extends JsonSerializer<Application> {

    @Override
    public void serialize(Application value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ToXmlGenerator xmlGen = (ToXmlGenerator) gen;
        xmlGen.writeStartObject();
        for (Map.Entry<String, Object> entry : value.getEntry().entrySet()) {
            xmlGen.writeObjectFieldStart("entry");
            writeAttributes(xmlGen, entry.getKey());
            xmlGen.writeRaw(entry.getValue().toString());
            xmlGen.writeEndObject();
        }
        xmlGen.writeEndObject();
    }

    private void writeAttributes(ToXmlGenerator gen, String key) throws IOException {
        gen.setNextIsAttribute(true);
        gen.writeFieldName("key");
        gen.writeString(key);
        gen.setNextIsAttribute(false);
    }
}