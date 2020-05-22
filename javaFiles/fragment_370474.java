class Employee {

    @Trim
    @LowerCase
    @Parsed
    private String firstName;

    @Parsed
    private String lastName;

    @NullString(nulls = { "?", "-" }) // if the value parsed in the quantity column is "?" or "-", it will be replaced by null.
    @Parsed(defaultNullRead = "0") // if a value resolves to null, it will be converted to the String "0".
    private Integer salary; // The attribute name will be matched against the column header in the file automatically.
    ...

}