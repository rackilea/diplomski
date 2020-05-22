public class CustomLogLevelJsonProvider extends LogLevelJsonProvider {
    @Override
    public void writeTo(JsonGenerator generator, ILoggingEvent event) throws IOException {
        JsonWritingUtils.writeStringField(
                generator, getFieldName(), event.getLevel().toString().toLowerCase());
    }
}