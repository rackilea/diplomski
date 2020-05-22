import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
...
private static ObjectMapper mapper = new ObjectMapper();
private static JsonFactory factory = mapper.getJsonFactory();