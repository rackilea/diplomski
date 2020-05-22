class User {

    private String userId;
    private String name;
    private String email;
    private String phone;

    @JsonCreator
    public User(Map<String, Object> map) {
        this.userId = (String) map.get("userId");
        map.entrySet().stream()
            .filter(e -> e.getKey().endsWith("_Name"))
            .findFirst()
            .ifPresent(e -> this.name = (String) e.getValue());
        // repeat for other fields
    }

    // getters & setters (if needed)
}