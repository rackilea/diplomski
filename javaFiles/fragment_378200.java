@JsonCreator
public User(@JsonProperty("username") String user,
            @JsonProperty("password") String pass,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("email") String email,
            @JsonProperty("company") String company,
            @JsonProperty("phone") String phone,
            @JsonProperty("monitorize") boolean monitorize,
            @JsonProperty("createP") boolean createP,
            @JsonProperty("openP") boolean openP,
            @JsonProperty("admin") boolean admin) {
            //your code;
}