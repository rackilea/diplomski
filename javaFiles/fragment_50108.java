import org.boon.json.annotations.JsonProperty;
import org.boon.json.annotations.SerializedName;

public static class Person {
    @SerializedName("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;
}