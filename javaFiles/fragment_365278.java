public static void parseSOAPPrimitiveObject(String input, Object output)
        throws NumberFormatException, IllegalArgumentException,
        IllegalAccessException, InstantiationException {

    Class theClass = output.getClass();
    Field[] fields = theClass.getDeclaredFields();

    for (int i = 0; i < fields.length; i++) {
        Type type = fields[i].getType();
        fields[i].setAccessible(true);

        // detect String
        if (fields[i].getType().equals(String.class)) {
            String tag = "" + fields[i].getName() + "";
            if (input.contains(tag)) {
                String strValue = "";
                strValue = input.substring(input.indexOf(tag)
                        + tag.length() + 2);

                if (getValueLength(strValue) > 0) {
                    strValue = getValue(strValue);
                } else {
                    strValue = "";
                }

                fields[i].set(output, strValue);
            }
        }

        // detect int or Integer
        if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            String tag = "" + fields[i].getName() + "";
            if (input.contains(tag)) {
                String strValue = "";
                strValue = input.substring(input.indexOf(tag)
                        + tag.length() + 2);
                fields[i].set(output, getValueLengthInt(strValue));
            }
        }
    }
}

public static String getValue(String substring) {

    String str = new String(substring);

    final Pattern pattern = Pattern.compile("\"(.+?)\"");
    final Matcher matcher = pattern.matcher(str);
    matcher.find();

    return matcher.group(0);
}

public static int getValueLength(String substring) {

    final Pattern pattern = Pattern.compile(":(.+?):");
    final Matcher matcher = pattern.matcher(substring);
    matcher.find();
    int count = 0;

    count = Integer.parseInt(matcher.group(1));

    return count;
}

public static int getValueLengthInt(String substring) {

    final Pattern pattern = Pattern.compile(":(.+?);");
    final Matcher matcher = pattern.matcher(substring);
    matcher.find();
    int count = 0;

    count = Integer.parseInt(matcher.group(1));

    return count;
}