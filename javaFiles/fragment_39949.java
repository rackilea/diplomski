import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Main3 {
private static String json = "{\n" +
        "    \"tasks\": [\n" +
        "      {\n" +
        "        \"id\": 1,\n" +
        "        \"code\": \"CODE\",\n" +
        "        \"description\": \"Dummy Task\",\n" +
        "        \"withConfirmation\": false,\n" +
        "        \"resource\": {\n" +
        "          \"id\": \"abcdef12-fe14-57c4-acb5-1234e7456d62\",\n" +
        "          \"group\": \"Doctor\",\n" +
        "          \"firstname\": \"Toto\",\n" +
        "          \"lastname\": \"Wallace\"\n" +
        "      }},\n" +
        "      {\n" +
        "        \"id\": 2,\n" +
        "        \"code\": \"CODE\",\n" +
        "        \"description\": \"Dummyyy Taaask\",\n" +
        "        \"withConfirmation\": false\n" +
        "      }\n" +
        "    ]\n" +
        " }";

public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    TasksList tl = mapper.readValue(json, TasksList.class);
    String result = mapper.writeValueAsString(tl);
    System.out.println(result);
}

private static class TasksList {
    @JsonProperty(value = "tasks")
    private List<Task> tasks;
}
@JsonIgnoreProperties(ignoreUnknown = true)
public static class Resource implements Serializable {
    @JsonProperty(value = "firstname")
    private String firstname;
    @JsonProperty(value = "lastname")
    private String lastname;

    // HAVE NO IDEA HOW YOU GONNA MAP THIS TO JSON
    // private MedicalGroup group; // id + name + description
    private Set<Task> tasks = new HashSet<Task>(0);

    @Override
    public String toString() {
        return "Resource{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}

@JsonAutoDetect
public static class Task implements Serializable {

    private Integer id;
    private String code = "BASIC";
    private String description;
    private boolean withConfirmation = false;

    /**
     * CONSTRUCTOR
     */
    public Task() {
    }
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public boolean isWithConfirmation() {
        return withConfirmation;
    }
    public void setWithConfirmation(boolean withConfirmation) {
        this.withConfirmation = withConfirmation;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {

        HashMap<String, Object> map= new HashMap<>();

        // IMPORTANT
        // here we can try to find resource that has this task
        // and export its info to json like this:
        // CHANGE THIS

        Resource res = new Resource();
        res.firstname = "Toto";
        res.lastname = "Wallace";

        // IMPORTANT END

        map.put("resource", res);

        return map;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Resource value) {
        // IMPORTANT
        // Probably here you have to create or find appropriate Resource in your code
        // and add current task to it
        System.out.println(name+" "+ value );
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", withConfirmation=" + withConfirmation +
                '}';
    }
}
}