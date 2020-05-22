@Converter
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount attribute) {...}

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal dbData) {...}
}