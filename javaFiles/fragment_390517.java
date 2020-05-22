import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class JsonNodeDeserializer extends JsonDeserializer<JsonNode> {

    @Override
    public JsonNode deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        String value = parser.getText();
        if(value == null) {
            return null;
        }
        return (JsonNode) context.findRootValueDeserializer(context.constructType(JsonNode.class)).deserialize(parser, context);
    }
}