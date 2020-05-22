import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        String json = "{\"Key1\": \"value1\", \"Key2\": { \"Key2.1\": \"value2.1\" }, \"Key3\":[{\"pRiMe\":11}]}";
        Map<String, Object> map = convertJsonStringToMap(json);

        System.out.println(map);
    }

    private static Map<String, Object> convertJsonStringToMap(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        transformKeys(node);

        TypeReference mapType = new TypeReference<Map<String, Object>>() {
        };

        return mapper.convertValue(node, mapType);
    }

    private static void transformKeys(JsonNode parent) {
        if (parent.isObject()) {
            ObjectNode node = (ObjectNode) parent;

            List<String> names = new ArrayList<>();
            node.fieldNames().forEachRemaining(names::add);

            names.forEach(name -> {
                JsonNode item = node.remove(name);
                transformKeys(item);
                node.replace(name.toLowerCase(), item);
            });
        } else if (parent.isArray()) {
            ArrayNode array = (ArrayNode) parent;
            array.elements().forEachRemaining(JsonApp::transformKeys);
        }
    }
}