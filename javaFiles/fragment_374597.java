public class WitMsgResponse {
    @JsonProperty("msg_id")
    String msgId;

    @JsonProperty("_text")
    String text;

    @JsonProperty("entities")
    public Map<String,List<Map<String,Object>>> entities;
}