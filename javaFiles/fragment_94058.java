class PayPalFieldNamingStrategy implements FieldNamingStrategy {

    @Override
    public String translateName(Field f) {
        return f.getType() == String.class ? f.getName() : FieldNamingPolicy.UPPER_CAMEL_CASE.translateName(f);
    }
}