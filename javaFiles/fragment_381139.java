import com.google.gson.annotations.SerializedName;

public class RequestHeader {
    @SerializedName("version")
    private String version;
    @SerializedName("locale")
    private String locale;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}