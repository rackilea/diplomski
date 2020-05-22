public class MyResponse implements Serializable {

    private boolean isSuccess;

    @JsonProperty(value="isSuccess")        
    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}