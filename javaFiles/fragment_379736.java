boolean check(Object obj, String fieldName, String operator, String value) throws IllegalArgumentException, someOtherExceptions {
    Field field = obj.getClass().getField(fieldName);
    if (operator.equals("equals") {
        return field.get().equals(value);
    }
    if (operator.equals("<=")) {
        return field.get().compareTo(value) <=0;
    }
    if (operator.equals("<")) {
        return field.get().compareTo(value) < 0;
    //other operators impl.
    //at the end:
    throw new IllegalArgumentException("Unknown operator");
}