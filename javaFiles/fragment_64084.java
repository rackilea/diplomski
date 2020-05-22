public class MyModel {
    private String signature;
    private String timestamp;

    public MyModel() {
        // constructor
    }

    public MyModel(String signature, String timestamp){
        this.signature = signature;
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}