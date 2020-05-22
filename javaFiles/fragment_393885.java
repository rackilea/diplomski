import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("message")
@Expose
private String message;
@SerializedName("success")
@Expose
private String success;
@SerializedName("sessionKey")
@Expose
private String sessionKey;
@SerializedName("data")
@Expose
private String data;

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getSuccess() {
return success;
}

public void setSuccess(String success) {
this.success = success;
}

public String getSessionKey() {
return sessionKey;
}

public void setSessionKey(String sessionKey) {
this.sessionKey = sessionKey;
}

public String getData() {
return data;
}

public void setData(String data) {
this.data = data;
}

}