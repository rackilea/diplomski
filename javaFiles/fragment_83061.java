import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<ItemJson, String> {

    @Override
    public String convertToDatabaseColumn(ItemJson entityValue) {
        if( entityValue == null )
            return null;

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(entityValue);
    }

    @Override
    public ItemJson convertToEntityAttribute(String databaseValue) {
        if( databaseValue == null )
            return null;

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(databaseValue, ItemJson.class);

    }
}