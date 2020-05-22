public class Employee {
    @JsonProperty("id")
    private String id;
    private String name;

    @JsonIgnore
    private Float score;
    public String getId() {
        return id;
    }
    public void setEmployeeId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setEmployeeName(String name) {
        this.name = name;
    }
    public Float getScore() {
        return score;
    }
    public void setScore(Float score) {
        this.score = score;
    }
}