@JsonRootName(value = "d")
public class PortalAccount implements Serializable{
    public PortalAccount() {
    }

    @JsonProperty("AccountID")
    public String accountID;

    @JsonProperty("Username")
    public String username;

    ...
}