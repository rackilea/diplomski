public class Entry {

    private Integer day;
    private String site;
    private int[] cpms;

    @JsonCreator
    public Entry(@JsonProperty("cpms") String cpms) {
        String[] values = cpms.replace("[", "").replace("]", "").split(",");
        this.cpms = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
    }

    // Getters and setters
}