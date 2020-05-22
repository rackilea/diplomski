class Player {

         @JsonProperty(user_id)
         private long userId;

         @JsonSerialize(using = JsonPlayerSerializer .class)
         private byte[] history;
        }