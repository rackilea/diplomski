public class LocalDateCon implements Converter{

    public boolean canConvert(Class type) {
        //return type.equals(LocalDate.class);
        return LocalDate.class.isAssignableFrom(type);
    }

    private static final String            DEFAULT_DATE_PATTERN = "dd-MM-yyyy";
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        LocalDate  date = (LocalDate) value;
        String result = date.format(DEFAULT_DATE_FORMATTER);
        writer.setValue(result);
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        LocalDate result = LocalDate.parse(reader.getValue(), DEFAULT_DATE_FORMATTER);
        return result;
    }

}