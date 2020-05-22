@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
abstract class SampleMixin {
    @JsonCreator
    public SampleMixin(@JsonProperty("id") int id) {
    }
}