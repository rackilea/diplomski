int i = 0;
for(Object value : temp) {
    if (value == null) {
        // set null parameter if value type is null and type is unknown
        pstmt.setNull(++i, Integer.MIN_VALUE); 
    } else {
        pstmt.setObject(++i, value);
    }
}