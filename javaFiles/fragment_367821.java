import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"Field1\": 20121220.00,\"Field3\":\"test\", \"Field2\":\"null\"}";

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

        XmlMapper xmlMapper = new XmlMapper();

        JsonNode tree = jsonMapper.readTree(jsonString);

        String jsonAsXml = xmlMapper.writer().with(Feature.WRITE_BIGDECIMAL_AS_PLAIN).writeValueAsString(tree);
        System.out.println(jsonAsXml);
    }
}