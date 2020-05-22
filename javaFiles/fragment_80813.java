public class LocalDateTimeAdapter extends 
    XmlAdapter<String, LocalDateTime> {
    public LocalDateTime unmarshal(String value) {
        return value == null ? null : LocalDatTime.parse(value);
    }
    // ...
}