class Pojo {
    @SerializedName("created_at")
    private String createdAt;
    private String id;
    private User user;
}

class User {
    @SerializedName("id_str")
    private String idStr;
    private String name;
    @SerializedName("screen_name")
    private String screenName;
}

// with appropriate getters, setters, and a toString() method