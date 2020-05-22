@Converter(autoApply = true)
public class MyEnumConverter implements AttributeConverter<List<MyEnum>, String> {

    @Override
    public String convertToDatabaseColumn(List<MyEnum> myEnums) {
        ...
    }

    @Override
    public List<MyEnum> convertToEntityAttribute(String dbData) {
        ...
    }

}