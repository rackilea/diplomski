service.addConverter(new Converter<String, LocalTime>() {
    @Override
    public LocalTime convert(String source) {
        return LocalTime.parse(source);
    }
});