@Override
public Object getAsDate(String value) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

    return formatter.parse(value);
}