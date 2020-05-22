import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mode {

  @JsonProperty("mode")
  long mode;

  @JsonProperty("enabled")
  boolean enabled;

  @JsonProperty("value")
  String value;

  @Override
  public String toString() {
    return "Mode{" +
        "mode=" + mode +
        ", enabled=" + enabled +
        ", value='" + value + '\'' +
        '}';
  }

  public static void main(String[] args) throws IOException {
    String json = "{\n"
        + "    \"100\": {\n"
        + "        \"mode\": 100,\n"
        + "        \"enabled\": true,\n"
        + "        \"value\": \"someString\"\n"
        + "    },\n"
        + "    \"101\": {\n"
        + "        \"mode\": 101,\n"
        + "        \"enabled\": false,\n"
        + "        \"value\": \"someString\"\n"
        + "    }\n"
        + "}";

    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<HashMap<String, Mode>> typeRef = new TypeReference<HashMap<String, Mode>>() {
    };
    Map<String, Mode> map = objectMapper.readValue(json, typeRef);
    map.entrySet().forEach(entry-> System.out.println(entry.getKey() + " : " +entry.getValue() ));
  }
}