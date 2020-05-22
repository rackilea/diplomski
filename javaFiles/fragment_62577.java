public class MessageWrapper {
  public Message message;
  @JsonCreator
  public MessageWrapper(@JsonProperty("message") Message m) { 
       message = m; 
  }
}