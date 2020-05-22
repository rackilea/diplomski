DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE ;

StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
    @Override
    public LocalDate fromString(String string) {
        return string == null || string.isEmpty() ? null : LocalDate.parse(string, formattter);
    }
    @Override
    public String toString(LocalDate date) {
        return date == null ? null : formatter.format(date);
    }
};