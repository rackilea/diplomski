String test = "a=5.31,b=2.004,c=3.1230";
//                          | [letter(s)]=
//                          |    | group 1: digits and dots
//                          |    | 
Pattern p = Pattern.compile("\\w+=([\\d.]+)");
Matcher m = p.matcher(test);
// iterating on findings
while (m.find()) {
    // back-reference
    String match = m.group(1);
    // trying to parse combination of digits and dots as double
    try {
        double d = Double.valueOf(match);
        System.out.printf("Found double: %f%n", d);
    }
    // handling non-parseable combinations of digits and dots
    catch (NumberFormatException nfe) {
        // TODO handle
        System.out.printf("Couldn't parse %s as double.%n", match);
    }
}