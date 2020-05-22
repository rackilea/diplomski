// assuming multi-line, but not relevant
String input = 
    "ECLONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS\n"
    + "ECLONG_TEXT_INSIDE_THIS2|LONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS\n"
    + "ECLONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS\n"
    + "ECLONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS|LONG_TEXT_INSIDE_THIS";
    //                            | look behind for "EC"
    //                            |     | match any+ character reluctantly
    //                            |     |  | look ahead for "|" (escaped)
    Pattern p = Pattern.compile("(?<=EC).+?(?=\\|)");
    Matcher m = p.matcher(input);
    while (m.find()) {
        System.out.println(m.group());
    }