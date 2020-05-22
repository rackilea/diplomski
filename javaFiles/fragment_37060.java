import javax.persistence.AttributeConverter;

public class MyConverter implements AttributeConverter<Date, Long> {

    public Long convertToDatabaseColumn(Date attribute) {
        return attribute.getTime();
    }

    public Date convertToEntityAttribute(Long dbData) {
        return new Date(dbData);
    }

}