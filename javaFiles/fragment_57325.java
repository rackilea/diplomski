import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createJsonParser("{\"id\":\"1S200D\", \"path\":\"/tmp/test/file.txt\"}");
        Entity employee = objectMapper.readValue(parser, Entity.class);
        System.out.println(employee);
    }
}

class Entity {

    private String id;
    private File path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", path=" + path + "]";
    }
}