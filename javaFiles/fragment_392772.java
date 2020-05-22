class LocalDateDeserializer extends StdDeserializer<LocalDate> {

protected LocalDateDeserializer(){
    super(LocalDate.class);
}

@Override
public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
    return LocalDate.parse(jp.readValueAs(String.class));

}
}