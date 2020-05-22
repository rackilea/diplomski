class Player {

     @JsonProperty(user_id)
     private long userId;

     @JsonIgnore
     private byte[] history;
    }