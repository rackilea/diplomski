public class MainJsonConfiguration{
    private String name;
    private String surname;
    private String address;
    private FatherKey fatherKey;

    public MainJsonConfiguration(@JsonProperty("name") String name,
        @JsonProperty("surname") String surname,
        @JsonProperty("address") String address,
        @JsonProperty("FatherKey") FatherKey fatherKey){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.fatherKey = fatherKey;

    }
}

public class FatherKey{

    private ChildKey childKey1;
    private ChildKey childKey2;

    public FatherKey(@JsonProperty("ChildKeyNo1") ChildKey  childKey1,
        @JsonProperty("ChildKeyNo2") ChildKey  childKey2){
        this.childKey1 = childKey1;
        this.childKey2 = childKey2;
    }
}

public class ChildKey{

    private String defaultKey;
    private String key1;
    private String key2;

    public ChildKey(@JsonProperty("defaultKey") String defaultKey,
        @JsonProperty("key1") String key1,
        @JsonProperty("key2") String key2){
        this.defaultKey = defaultKey;
        this.key1 = key1;
        this.key2 = key2;
    }
}