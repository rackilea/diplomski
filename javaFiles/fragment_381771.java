public class LoginInfo_POJO {
    // If you rename the fields
    public String ok;
    public String msg;
    public List<Dataset> data;

    // If you use annotation
    @SerializedName("ok")
    public String _ok;
    @SerializedName("msg")
    public String _msg;
    @SerializedName("data")
    public String _dataset;
}