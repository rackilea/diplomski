@JsonInclude(JsonInclude.Include.NON_EMPTY)
public static class Attribute {

    private String label;
    @JsonInclude
    private String name;        // Mandatory
    @JsonInclude
    private String description; // Mandatory
    @JsonInclude
    private String type;        // Mandatory