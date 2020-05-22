import com.google.gson.annotations.SerializedName;

public class RequestContainer<T> {
    @SerializedName("header")
    private RequestHeader requestHeader;
    @SerializedName("body")
    private T body;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}