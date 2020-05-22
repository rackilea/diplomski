import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestJson {

    private static final String JSON = "{\n" +
            "    \"store\": {\n" +
            "        \"book\": [\n" +
            "            {\n" +
            "                \"category\": \"reference\",\n" +
            "                \"author\": \"Nigel Rees\",\n" +
            "                \"title\": \"Sayings of the Century\",\n" +
            "                \"price\": 8.95\n" +
            "            }\n" +
            "        ],\n" +
            "        \"bicycle\": {\n" +
            "            \"color\": \"red\",\n" +
            "            \"price\": 19.95\n" +
            "        }\n" +
            "    },\n" +
            "    \"expensive\": 10\n" +
            "}";

    @Test
    public void testJson() {
        assertTrue(assertJsonValue(JSON, "store.(book)[0].category", "reference"));
        assertTrue(assertJsonValue(JSON, "store.(book)[0].author", "Nigel Rees"));
        assertTrue(assertJsonValue(JSON, "store.(book)[0].title", "Sayings of the Century"));
        assertTrue(assertJsonValue(JSON, "store.(book)[0].price", 8.95));
    }

    public boolean assertJsonValue(String jsonString,
                                   String path,
                                   Object expectedValue) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object actual = PropertyUtils
                    .getProperty(objectMapper.readValue(jsonString, Object.class), path);

            if (actual.equals(expectedValue)) {
                return true;
            }

        } catch (IOException | ReflectiveOperationException e) {
            // handle error
        }
        return false;
    }
}