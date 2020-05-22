public String getValue(String colName) throws Exception {

    final String name = colName != null ? colName.trim().toUpperCase() : "";

    for (EConstants.StringAttributes attribute : EConstants.StringAttributes.values())
        if (name.equals(attribute))
            return callAsStringMethod().toString();

    for (EConstants.IntegerAttributes attribute : EConstants.IntegerAttributes.values())
        if (name.equals(attribute))
            return callAsIntegerMethod().toString();

    throw new Exception("column not found");

}