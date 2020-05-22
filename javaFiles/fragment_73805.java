import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        List<Map> nodes = JsonPath.parse(jsonFile).read("$..value[*].user.name");

        ObjectMapper mapper = new ObjectMapper();
        CollectionType usersType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
        List<User> users = mapper.convertValue(nodes, usersType);
        System.out.println(users);
    }
}

class User {

    @JsonProperty("first")
    private String firstName;

    @JsonProperty("last")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}