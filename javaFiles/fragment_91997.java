public MyRowMapper getRow(String... queryParameters) {
    //query table based on queryParameters
    MyRowMapper mapper = null;
    if (cursor.moveToFirst()) {
        String foo = cursor.getString(cursor.getColumnIndexOrThrow("FOO"));
        Integer bar = cursor.getInteger(cursor.getColumnIndexOrThrow("BAR"));
        String baz = cursor.getString(cursor.getColumnIndexOrThrow("BAZ"));

        mapper = new MyRowMapper(foo, bar, baz);            
    }
    cursor.close(); // NEVER FORGET TO CLOSE YOUR CURSOR!
    return mapper;
 }