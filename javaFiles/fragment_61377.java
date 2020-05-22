import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.readValue(jsonFile, Response.class));
    }
}

class Response {

    @JsonProperty("ProviderData")
    private ProviderData data;

    // getters, setters, toString
}

class ProviderData {

    private static final String INVALID_NAME = "INVALID";
    private static final String TEXT_NAME = "#text";

    @JsonProperty(INVALID_NAME)
    private final String invalid;

    @JsonProperty(TEXT_NAME)
    private final String text;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ProviderData(String invalid) {
        this(invalid, null);
    }

    @JsonCreator
    public ProviderData(@JsonProperty(INVALID_NAME) String invalid, @JsonProperty(TEXT_NAME) String text) {
        this.invalid = invalid;
        this.text = text;
    }

    // getters, toString
}