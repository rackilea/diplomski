@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @Type(name = "SMS", value = SmsLog.class),
    @Type(name = "CALL", value = CallLog.class)
})
public abstract class JsonLog {
}