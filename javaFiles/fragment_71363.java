class Replies {

    @JsonAdapter(RepliesJsonDeserializer.class)
    private List<Reply> replies;

    // getters, setters, toString
}