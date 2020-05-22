public class BigDecimalConverter implements AttributeConverter<BigDecimal, double> {

    @Override
    public double convertToDatabaseColumn(BigDecimal bigDecimalValue) {
        if(bigDecimalValue == null) {
            return null;
        }

        return bigDecimalValue.doubleValue();
    }

    @Override
    public BigDecimal convertToEntityAttribute(double doubleValue) {
        if(doubleValue == null) {
            return null;
        }

        return BigDecimal.valueOf(doubleValue);
    }
}