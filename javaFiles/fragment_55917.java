import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.File;
import java.io.IOException;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./src/main/resources/test.json");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(jsonFile, User.class));
    }
}

class PropertyExistsJsonDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        p.readValueAsTree(); //consume value
        return Boolean.TRUE;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
class User {
    private int id;

    @JsonDeserialize(using = PropertyExistsJsonDeserializer.class)
    @JsonProperty("picture")
    private boolean pictureAvailable;

    //getters, setters, toString
}