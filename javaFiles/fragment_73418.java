import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class User {

    public static void main(String[] args) throws JsonProcessingException, IOException {

        String json = "{\"User\":{\"firstname\":\"john\",\"gender\":\"female\",\"verified\":\"no\"}}";
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader(User.class).withRootName("User");
        User user = reader.readValue(json);

        System.out.println(user.getFirstname());
    }

    private String firstname;
    private String lastname;
    private String verified;
    private String gender;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}