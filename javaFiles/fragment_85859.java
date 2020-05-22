import org.codehaus.jackson.annotate.JsonProperty;

public class Users {

    @JsonProperty("Values")
    private Details Values;

    public Details getValues() {
        return this.Values;
    }

    public void setValues(Details Values) {
        this.Values = Values;
    }
}



import org.codehaus.jackson.annotate.JsonProperty;

public class Details {
@JsonProperty("user_name")
private String user_name;
@JsonProperty("user_password")
private String user_password;
@JsonProperty("age")
private int age;
@JsonProperty("user_email")
private String user_email;

public String getUserName() {
    return this.user_name;
}

public void setUserName(String user_name) {
    this.user_name = user_name;
}

public String getUserPassword() {
    return this.user_password;
}

public void setUserPassword(String user_password) {
    this.user_password = user_password;
}

public int getAge() {
    return this.age;
}

public void setAge(int age) {
    this.age = age;
}

public String getUserEmail() {
    return this.user_email;
}

public void setUserEmail(String user_email) {
    this.user_email = user_email;
}