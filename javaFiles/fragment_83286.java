public class Key implements Serializable {
    @Field(order = 1)
    private final @NotNull String region;
    @Field(value = "id", order = 2)
    private final @NotNull String id;
    public Key(@NotNull String region, @NotNull String id) {
        this.region = region;
        this.id = id;
    }
}