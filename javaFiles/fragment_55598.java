//Get any last 6 digits
    String pattern = "(.*)([0-9])([0-9])([0-9])([0-9])([0-9])([0-9])(.*)";
    Pattern p = Pattern.compile(pattern);
    String updated = "<p align=\"center\"><font class=\"bodytext\"><strong><u>Address</u></strong><br /> 123 Upper East , text text2 s (s)465561 </font></p>";
    Matcher m = p.matcher(updated);
    if(m.matches()){
        System.out.println(m.group(2)+m.group(3)+m.group(4)+m.group(5)+m.group(6)+m.group(7));

    }