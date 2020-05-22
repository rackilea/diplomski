public static class Message {
    private String name;
    private boolean status;
    @JsonSerialize(using=ToStringSerializer.class)
    private JSONObject requestMessage;
    // ...
}