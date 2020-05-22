public class Response {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    // getter/setter...
}
public class Data {
    @JsonProperty("response")
    private List<Response> response;
    @JsonProperty("errorMsg")
    private String errorMsg;
    @JsonProperty("code")
    private int code;
    // getter/setter...
}