@Table(name = "users")
public static class User {
    @PartitionKey
    @Column(name = "user_id")
    private UUID userId;
    private String name;
    // ... constructors / getters / setters
}