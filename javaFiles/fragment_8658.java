import com.fasterxml.jackson.databind.ObjectMapper;
public class Test {

public static void main(String[] args) throws Exception {
    String locations = "[{\"code\":\"b\",\"name\":\"Beavercreek\"},{\"code\":\"bj\",\"name\":\"Beavercreek Juvenile\"}]";

    // Parsing Using a JSON Parser (Recommended)
    ObjectMapper jsonMapper = new ObjectMapper();
    Model[] modelArray = jsonMapper.readValue(locations, Model[].class);

    for(Model model : modelArray) {
        System.out.println(model.toString());
    }

    // Parsing Using String.replaceAll with regex
    locations = locations.replaceAll("\\{\"code\":", "");
    locations = locations.replaceAll("\"name\":", "");

    System.out.println(locations.replaceAll("\\}", ""));
}

static class Model {
    private String code;
    private String name;

    public Model() { }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", code, name);
    }
}
}