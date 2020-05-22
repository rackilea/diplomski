public class CustomDeserializer extends LocalDateTimeDeserializer {
    public CustomDeserializer() {
        super(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}

public class CustomSerializer extends LocalDateTimeSerializer {
    public CustomSerializer() {
        super(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS a"));
    }
}

// in this case, don't use @JsonFormat
@JsonSerialize(using = CustomSerializer.class)
@JsonDeserialize(using = CustomDeserializer.class)
private LocalDateTime time;