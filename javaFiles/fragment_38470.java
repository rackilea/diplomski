@org.codehaus.jackson.map.annotate.JsonSerialize(using = OAuth2ExceptionJackson1Serializer.class)
@org.codehaus.jackson.map.annotate.JsonDeserialize(using = OAuth2ExceptionJackson1Deserializer.class)
@com.fasterxml.jackson.databind.annotation.JsonSerialize(using = OAuth2ExceptionJackson2Serializer.class)
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = OAuth2ExceptionJackson2Deserializer.class)
public class CustomOauthException extends OAuth2Exception {

    private static final long serialVersionUID = 124661L;

    public CustomOauthException(String msg) {
        super(msg);
    }
    private String oaut_error_code;
    private int http_error_code;


    public CustomOauthException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public int getHttpErrorCode() {
        return this.http_error_code;
    }


    public int getHttp_error_code() {
        return http_error_code;
    }

    public void setHttp_error_code(int http_error_code) {
        this.http_error_code = http_error_code;
    }

    @Override
    public String getOAuth2ErrorCode() {
        return oaut_error_code;
    }



    public void setOaut_error_code(String oaut_error_code) {
        this.oaut_error_code = oaut_error_code;
    }





}