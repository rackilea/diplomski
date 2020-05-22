import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.Objects;

public class JsonMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public JsonMapper() {
        // configure mapper instance if required
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        // etc...
    }

    public String serialise(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Could not generate JSON!", e);
        }
    }

    public <T> T deserialise(String payload, Class<T> expectedClass) {
        Objects.requireNonNull(payload);
        Objects.requireNonNull(expectedClass);

        try {
            return mapper.readValue(payload, expectedClass);
        } catch (IOException e) {
            throw new IllegalStateException("JSON is not valid!", e);
        }
    }

    public Foo parseResponseFoo(String payload) {
        return deserialise(payload, Foo.class);
    }

    public Bar parseResponseBar(String payload) {
        return deserialise(payload, Bar.class);
    }

    public static void main(String[] args) {
        JsonMapper jsonMapper = new JsonMapper();

        String bar = "{\"bar\" : 2}";
        System.out.println(jsonMapper.parseResponseBar(bar));

        String foo = "{\"foo\" : 1}";
        System.out.println(jsonMapper.parseResponseFoo(foo));

        System.out.println("General method:");
        System.out.println(jsonMapper.deserialise(foo, Foo.class));
        System.out.println(jsonMapper.deserialise(bar, Bar.class));
    }
}

class Foo {

    public int foo;

    @Override
    public String toString() {
        return "Foo{" +
                "foo=" + foo +
                '}';
    }
}

class Bar {

    public int bar;

    @Override
    public String toString() {
        return "Bar{" +
                "bar=" + bar +
                '}';
    }
}