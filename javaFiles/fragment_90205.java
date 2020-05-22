public class AnswerDto<T> {

    private String uuid;

    private AnswerType type;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Location.class, name = AnswerType.Types.LOCATION),
            @JsonSubTypes.Type(value = JobTitle.class, name = AnswerType.Types.JOB_TITLE)
    })
    private T value;
}