public boolean validate(Object toValidate, String arguments) {
    List<Integer> values = new ArrayList<>();
    BaseType<?> baseType = BaseType.getBaseType(arguments);
    if (List.class.equals(baseType.getType)) {
        List<BaseType<?>> listType = (List<BaseType<?>>)baseType.getValue();
        for (BaseTyep<?> base : listType) {
            if (Integer.class.equals(base.getType())) {
                values.add(base.getValue());
            }
        }
    }
    ...
}