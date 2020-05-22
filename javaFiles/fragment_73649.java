import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        C1 c1 = new C1();
        c1.setProp1("a");
        c1.setProp3("c");

        User user = new User();
        user.setName("Tom");
        user.setSurname("Irg");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.convertValue(c1, UriFormat.class));
        System.out.println(mapper.convertValue(user, UriFormat.class));
    }
}

class UriFormat {

    private StringBuilder builder = new StringBuilder();

    @JsonAnySetter
    public void addToUri(String name, Object property) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        builder.append(name).append("=").append(property);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}