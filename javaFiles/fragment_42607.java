public String getValue(String colName) throws Exception {

    final String name = colName != null ? colName.trim().toUpperCase() : "";

    try {
        EConstants.StringAttributes.valueOf(name);
        return callAsStringMethod().toString();
    } catch (Exception e1) {
        try {
            EConstants.IntegerAttributes.valueOf(name);
            return callAsIntegerMethod().toString();
        } catch (Exception e2) {
            throw new Exception("column not found");
        }
    }

}