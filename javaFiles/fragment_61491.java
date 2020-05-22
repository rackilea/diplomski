public class EntityDto {

    private Map<String, Object> content;

    @JsonCreator
    public EntityDto(Map<String, Object> content) {
        this.content = content;
    }

    // Getters and setters omitted
}