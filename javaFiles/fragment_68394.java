public void apply(PreparedStatement pstmt, int param, String typeName, Object value) {
    try {
        Class<?> types = Types.class;
        Field field = types.getField(typeName);
        int typeValue = field.getInt(null);

        pstmt.setObject(param, obj, typeValue);
    } catch (Exception e) {
        // handle exceptions
    }
}