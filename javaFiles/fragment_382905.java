import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test2 {
    public static void main(String[] args) throws JsonProcessingException {
        UserWithRoot user = new UserWithRoot(1, "John");

        ObjectMapper objectMapper = new ObjectMapper();

        String userJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);

        System.out.println(userJson);
    }

    @JsonTypeName(value = "user")
    @JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
    private static class UserWithRoot {
        public int id;
        public String name;
    }
}