class TestBean {

    @NullString(nulls = { "?", "-" }) // if the value parsed in the quantity column is "?" or "-", it will be replaced by null.
    @Parsed(defaultNullRead = "0") // if a value resolves to null, it will be converted to the String "0".
    private Integer quantity; // The attribute name will be matched against the column header in the file automatically.

    @Trim
    @LowerCase
    @Parsed
    private String comments;
    ...

}