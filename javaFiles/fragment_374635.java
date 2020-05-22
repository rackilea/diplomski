@JsonDeserialize(builder = Message.class)
public class Message {

    ...

    @JsonSetter("saved_by")
    public void setSavedBy(Set<Long> savedBy) {
        // Merely store the value for later use.
        this.savedBy = savedBy;
    }

    ...

    public Message build() {
        // Calculate value of "saved" field.
        this.saved = this.savedBy.contains(getUserIdByChannelId(this.channelId));
        return this;
    }

    // Handling the added challenge.
    @JsonProperty("data") 
    public void setData(JsonNode data) throws JsonProcessingException {
       ...
    }
}