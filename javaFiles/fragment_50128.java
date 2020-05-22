public class User {

    private boolean admin;

    private String alias;

    private String email;

    @JsonDeserialize(using = StringValueDeserializer.class)
    private String emailId;

    @JsonDeserialize(using = StringArrayValueDeserializer.class)
    private ArrayList<String> groups;

    @JsonDeserialize(using = StringValueDeserializer.class)
    private String id;

    private boolean locked;

    private int loggedInCount;

    private boolean master;

    private String sms;

    @JsonDeserialize(using = StringValueDeserializer.class)
    private String smsId;

    private String type;

    private String username;
    .... getter and setter
}