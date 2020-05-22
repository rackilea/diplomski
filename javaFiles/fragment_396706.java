import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;

public class EmbeddedJsonDeserializer
  extends JsonDeserializer<Object>
  implements ContextualDeserializer<Object>
{
  Class<?> type = null;
  public EmbeddedJsonDeserializer() {
  }

  public EmbeddedJsonDeserializer( Class<?> type ) {
    this.type = type;
  }

  @Override
  public Object deserialize(JsonParser parser, DeserializationContext context)
      throws IOException, JsonProcessingException {
    JsonToken curr = parser.getCurrentToken();
    if (curr == JsonToken.VALUE_STRING) {
      if( type == null ) return parser.getText();
      ObjectCodec codec = parser.getCodec();
      if( codec == null ) {
        return new ObjectMapper().readValue(parser.getText(), type);
      }
      else if( codec instanceof ObjectMapper ) {
        return ((ObjectMapper)codec).readValue(parser.getText(), type);
      }
      else if( codec instanceof ObjectReader ) {
        return ((ObjectReader)codec).withType(type).readValue(parser.getText());
      }
      else {
        return new ObjectMapper().readValue(parser.getText(), type);
      }
    }
    throw context.mappingException(type);
  }

  public JsonDeserializer<Object> createContextual(DeserializationConfig config, BeanProperty property) throws JsonMappingException {
    return new EmbeddedJsonDeserializer(property.getType().getRawClass());
  }
}