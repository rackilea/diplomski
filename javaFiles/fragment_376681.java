class JsonObj {

    @JsonProperty("response-code")
    private long responseCode;

    private ResponseObj response;

    public long getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(long responseCode) {
        this.responseCode = responseCode;
    }

    public ResponseObj getResponse() {
        return response;
    }

    public void setResponse(ResponseObj response) {
        this.response = response;
    }
}

class ResponseObj {

    private ArrayList<ResultObj> result;
    private String uri;

    public ArrayList<ResultObj> getResult() {
        return result;
    }

    public void setResult(ArrayList<ResultObj> result) {
        this.result = result;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}

class ResultObj {

    @JsonProperty("DISPLAYNAME")
    private String displayName;

    @JsonProperty("TYPE")
    private String type;

    @JsonProperty("AVAILABILITYSEVERITY")
    private int availabilitySeverity;

    @JsonProperty("RESOURCEID")
    private String resourceId;

    @JsonProperty("SHORTMESSAGE")
    private String shortMessage;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailabilitySeverity() {
        return availabilitySeverity;
    }

    public void setAvailabilitySeverity(int availabilitySeverity) {
        this.availabilitySeverity = availabilitySeverity;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }
}