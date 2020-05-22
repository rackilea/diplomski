import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class Test {
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    XmlMapper mapper = new XmlMapper();
    final SimpleModule module = new SimpleModule("configModule",   com.fasterxml.jackson.core.Version.unknownVersion());
    module.addDeserializer(Person.class, new DeSerializer());
    mapper.registerModule(module);
    // Person readValue = mapper.readValue(<xml source>);
  }
}

class DeSerializer extends StdDeserializer<Person> {

  protected DeSerializer() {
    super(Person.class);
  }

  @Override
  public Person deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    // use p.getText() and p.nextToken to navigate through the xml and construct Person object
    return new Person();

  }
}