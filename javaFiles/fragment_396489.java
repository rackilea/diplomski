import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class Test {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        String jsonString = "{\"test1\": {\"get\": {\"tags\": [\"restcalls1\"]}}, \"test2\": {\"put\": {\"tags\": [\"restcalls2\"] }}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);

        Iterator<JsonNode> iterator2 = rootNode.iterator();
        while (iterator2.hasNext()) {
            JsonNode node2 = iterator2.next().findParent("tags");
            ObjectNode objectNode = (ObjectNode) node2;
            objectNode.putArray("tags").add("my rest calls");
        }

        Iterator<JsonNode> iterator = rootNode.iterator();
        while (iterator.hasNext()) {
            JsonNode node2 = iterator.next();
            System.out.println(node2);
        }

    }
}