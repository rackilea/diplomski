Table t = db.getTable("Table1");
for (Row r : t) {
    Object o;
    Double d;
    String fieldName;

    fieldName = "DoubleField";
    o = r.get(fieldName);
    System.out.println(String.format(
            "%s comes back as: %s", 
            fieldName, 
            o.getClass().getName()));
    System.out.println(String.format(
            "Value: %f", 
            o));
    System.out.println();

    fieldName = "TextField";
    o = r.get(fieldName);
    System.out.println(String.format(
            "%s comes back as: %s", 
            fieldName, 
            o.getClass().getName()));
    System.out.println(String.format(
            "Value: %s", 
            o));
    try {
        d = r.getDouble(fieldName);
    } catch (Exception x) {
        System.out.println(String.format(
                "r.getDouble(\"%s\") failed - %s: %s", 
                fieldName, 
                x.getClass().getName(),
                x.getMessage()));
    }
    try {
        d = Double.parseDouble(r.getString(fieldName));
        System.out.println(String.format(
                "Double.parseDouble(r.getString(\"%s\")) succeeded. Value: %f", 
                fieldName, 
                d));
    } catch (Exception x) {
        System.out.println(String.format(
                "Double.parseDouble(r.getString(\"%s\")) failed: %s", 
                fieldName,
                x.getClass().getName()));
    }
    System.out.println();
}