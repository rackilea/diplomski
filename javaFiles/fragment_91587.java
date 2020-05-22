public class Test {
@Id
private String name;
@Transient
@JsonIgnore
private Duration duration;
@JsonProperty("duration")
private Duration durationString;

public Test() {
}

public Test(String name, Duration duration) {
    this.name = name;
    this.duration = duration;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Duration getDuration() {
    return duration;
}

public void setDuration(Duration duration) {
    this.duration = duration;
}}