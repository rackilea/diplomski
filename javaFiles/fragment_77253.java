import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

public class JsonApp {

  public static void main(String[] args) throws IOException {
    MultiMap<String, String> multiMap = new MultiValueMap<>();
    multiMap.put("a", "AA");
    multiMap.put("a", "AAA");
    multiMap.put("b", "B");
    multiMap.put("b", "BB");

    SimpleModule collections4Module = new SimpleModule();
    collections4Module.addAbstractTypeMapping(MultiMap.class, MultiValueMap.class);

    ObjectMapper jsonMapper = new ObjectMapper();
    jsonMapper.registerModule(collections4Module);

    String json = jsonMapper.writeValueAsString(multiMap);
    System.out.println(json);
    System.out.println(jsonMapper.readValue(json, MultiMap.class));
  }
}