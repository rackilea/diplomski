import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class MapTest {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        Foo foo = new Foo();
        foo.setId(1);
        foo.setName("foo test");

        final Gson gson = new Gson();
        final HashMap<String, Object> result = new ObjectMapper().readValue(gson.toJson(foo),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(result);
    }

}