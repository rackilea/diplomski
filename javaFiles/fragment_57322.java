@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, String>
{
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSSS xxx";

    @Override
    public String convertToDatabaseColumn(ZonedDateTime zonedDateTime)
    {
        return DateTimeFormatter.ofPattern(DATE_FORMAT).format(zonedDateTime);
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(String dateAsString)
    {
        return ZonedDateTime.parse(dateAsString, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}