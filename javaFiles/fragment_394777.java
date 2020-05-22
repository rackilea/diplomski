public abstract class JodaDateSerializer extends JsonSerializer<ReadablePartial> {

    protected abstract String getDateFormat();

    @Override
    public void serialize(ReadablePartial date, JsonGenerator gen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        String formattedDate = DateTimeFormat.forPattern(getDateFormat()).print(date);

        gen.writeString(formattedDate);
    }
}

public class LocalDateSerializer extends JodaDateSerializer {

    protected String getDateFormat(){
        return "yyyy-MM-dd";
    }

}

public class OtherDateSerializer extends JodaDateSerializer {

    protected String getDateFormat(){
        return "yyyy/MM/dd";
    }

}