import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test
{
    public static void main(String[] args)
    {
        try {
            String json = "{ "
                    + "\"string-property\": \"string-value\", "
                    + "\"int-property\": 1, "
                    + "\"bool-property\": true, "
                    + "\"collection-property\": [\"a\", \"b\", \"c\"], "
                    + "\"map-property\": {\"inner-property\": \"inner-value\"} "
                    + "}";

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
            // convert JSON string to Map
            map = mapper.readValue(json, new TypeReference<Map<String, Object>>(){});

            System.out.println("input: " + json);
            System.out.println("output:");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("key: " + entry.getKey());
                System.out.println("value type: " + entry.getValue().getClass());
                System.out.println("value: " + entry.getValue().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}