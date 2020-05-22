import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        SimpleModule module = new SimpleModule();
        module.setDeserializerModifier(new InsensitiveBeanDeserializerModifier());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);

        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);

        System.out.println(mapper.readValue(jsonFile, User.class));
    }
}