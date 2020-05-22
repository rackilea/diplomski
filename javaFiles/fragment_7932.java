class Response {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("ErrorCode")
    private  int errorCode;
    @JsonProperty("ResultCount")
    private  int resultCount;
    @JsonProperty("Trends")
    private Map<String, Trends> trends;
   }