import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;

public class JsonApp {

    public static void main(String[] args) throws IOException {
        String json = "{\"xyz\":\"X\",\"a\":1,\"yxz\":2}";
        DeserializationProblemHandler handler = new DeserializationProblemHandler() {
            @Override
            public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser p, JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName) throws IOException {
                System.out.println("Unknown property '" + propertyName + "' for " + beanOrClass.getClass());
                return true;
            }
        };
        JsonMapper mapper = JsonMapper.builder()
                .addHandler(handler)
                .build();

        mapper.readValue(json, MyClass.class);
    }
}