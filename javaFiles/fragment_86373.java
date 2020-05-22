import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper typeAwareMapper = new ObjectMapper();
        typeAwareMapper.enable(SerializationFeature.INDENT_OUTPUT);
        typeAwareMapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.NON_FINAL, "@class");

        String json = typeAwareMapper.writeValueAsString(new BarClass());
        System.out.println(json);

        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new OmitListTypeDeserializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        System.out.println(mapper.readValue(json, BarClass.class));
    }
}

class BarClass {
    private String barProp = "PROP1";
    private List<BarListElement> barList = Arrays.asList(new BarListElement(), new BarListElement());
    private Integer zet = 123;

    // getters, setters
}

class BarListElement {

    private Double sid = Math.random();

    // getters, setters
}