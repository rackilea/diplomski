try {
    // find the type of the field, and look for a String constructor
    return fieldType.getType().getConstructor(String.class).newInstance(sqlArg);
} catch (Exception e) {
    throw SqlExceptionUtil.create("could not call the string constructor on "
        + fieldType.getType(), e);
}