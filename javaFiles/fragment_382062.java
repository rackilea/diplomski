import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws IOException {
        File jsonFile = new File("./src/main/resources/test.json");

        ObjectMapper mapper = JsonMapper.builder().build();

        List<Tasks> tasks = new ArrayList<>();
        ArrayNode array = (ArrayNode) mapper.readTree(jsonFile);
        array.forEach(item -> tasks.add(mapper.convertValue(item.get("Task"), Tasks.class)));

        System.out.println(tasks);
    }
}

class Tasks {
    private String engType;
    private String refType;
    private String reference;

    @JsonProperty("DMC")
    private String dmc;

    private Map<String, String> subTasks;

    // getters, setters, toString
}