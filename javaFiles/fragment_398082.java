public class MainResponse {
public List<PhoneStatusResponse> phonesStatusList;

}

public class PhoneStatusResponse {
    @SerializedName("status")
    public int status;
    @SerializedName("message")
    public String message;
    @SerializedName("phoneRequest")
    public String phone;

}