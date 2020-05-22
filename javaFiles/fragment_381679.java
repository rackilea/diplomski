import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = JsonMapper.builder().build();
        Values values = mapper.readValue(jsonFile, Values.class);
        System.out.println(values.getValuesAsMap());
    }
}

class Values {

    private String name;
    private List<List<BigDecimal>> values;

    public Map<BigDecimal, BigDecimal> getValuesAsMap() {
        return values.stream().collect(Collectors.toMap(
                k -> k.get(0),
                v -> v.get(1),
                (u, v) -> {
                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                },
                LinkedHashMap::new));
    }

    // getters, setters, toString
}