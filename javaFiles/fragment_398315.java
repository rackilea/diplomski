import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Foo {
    private boolean prop;

    public boolean isProp() {
        return prop;
    }

    public void setProp(boolean prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "Foo{" +
            "prop=" + prop +
            '}';
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{ \n" +
            "     \"id1\": {\n" +
            "          \"prop\": true\n" +
            "     },\n" +
            "     \"id2\": {\n" +
            "          \"prop\": true\n" +
            "     },\n" +
            "     \"id3\": {\n" +
            "          \"prop\": true\n" +
            "     }\n" +
            " }";
        Map<String, Foo> map = mapper.readValue(json, new TypeReference<Map<String, Foo>>() {
        });

        System.out.println("map = " + map);
    }
}