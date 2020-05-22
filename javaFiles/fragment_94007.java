public boolean validate(Object toValidate, String arguments) {
    boolean value = false;
    BaseType<?> baseType = BaseType.getBaseType(arguments);
    if (Boolean.class.equals(baseType.getType)) {
        value = baseType.getValue();
    }
    ...
}