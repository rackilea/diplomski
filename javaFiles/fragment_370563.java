public class CarTypeConverter implements AttributeConverter<List<String>, String> {
    @Override
    public Long convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null) return null;
        return attribute.stream().reduce((x, y) -> x + "," + y).orElse("");
    }

    @Override
    public List<String> convertToEntityAttribute(String dbColumnValue) {
        if (dbColumnValue == null) return null;
        String[] typeArray = dbColumnValue.split(",");
        List<String> typeList = Arrays.stream(typesArray).collect(Collectors.toList());
        return typeList;
    }
}