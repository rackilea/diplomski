public class CustomLocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator generator, SerializerProvider sp)
            throws IOException, JsonProcessingException {
        String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
        generator.writeString( formattedDateTime);
    }

}