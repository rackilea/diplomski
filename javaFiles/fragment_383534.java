package de.scrum_master.app;

public class BaseResponse<T> {
    private String body;
    private String error = "OK";

    public void setBody(String body) {
        this.body = body;
    }

    public void setError(BaseError be) {
        error = be.getMessage();
    }

    @Override
    public String toString() {
        return "BaseResponse [body=" + body + ", error=" + error + "]";
    }
}