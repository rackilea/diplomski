import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {

    static final String TEST_JSON = "{"
            +" \"aaa@example.com\": {"
            +"  \"statement\": true"
            +"},"
            +"\"bbb@example.com\": {"
            +"  \"statement\": false"
            +"}"
            +"}";


    public static void main (String... args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Map<String, Map<String, Boolean>> jsonAsNestedMap = mapper.readValue(
                    TEST_JSON, new TypeReference<Map<String, Map<String, Boolean>>>() {
            });
            System.out.println(jsonAsNestedMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }        
    }

}