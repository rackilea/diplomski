public class Entry {

    private Integer day;
    private String site;

    @JsonDeserialize(using = QuotedArrayDeserializer.class)
    private int[] cpms;

    // Getters and setters
}