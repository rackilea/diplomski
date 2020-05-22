public static final synchronized <T> String serialize(final T object, final Boolean withHeaders) throws IOException {
    CsvMapper csvMapper = new CsvMapper();
    CsvSchema csvSchema = csvMapper.schemaFor(object.getClass());

    if (withHeaders) {
        csvSchema = csvSchema.withHeader();
    } else {
        csvSchema = csvSchema.withoutHeader();
    }

    return csvMapper.writer(csvSchema).writeValueAsString(object);
}