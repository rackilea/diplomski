final String regex = "(?:^(R)\\|(\\d+)\\|\\^*([^|]*)\\|([^|]*)\\|(?:([^|]*)\\|)?.*$)|(?:^(P)\\|(\\d+)\\|\\|(\\d+).*$)";
final String string = "P|1||322061||^|||U \n"
     + "O|1||138||||||||||||O \n"
     + "R|1|^^^BE(B)||mmol/L||C||||||20150819144937 \n"
     + "R|2|^^^BEecf||mmol/L||C \n"
     + "R|3|^^^Ca++|1.17|mmol/L \n"
     + "R|4|^^^Ca++(7.4)||mmol/L||C \n"
     + "R|5|^^^HCO23-||mmol/L||C \n"
     + "R|6|^^^HCO3std||mmol/L||C \n"
     + "R|7|^^^K+|5.0|mmol/L \n"
     + "R|8|^^^Na+|140|mmol/L \n"
     + "R|9|^^^SO2c||%||C \n"
     + "R|10|^^^TCO2||mmol/L||C \n"
     + "R|11|^^^THbc||g/dL||C \n"
     + "R|12|^^^Temp|37.0|C\n";

final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    //System.out.println("Full match: " + matcher.group(0));

    if(matcher.group(1)!=null && matcher.group(1).equalsIgnoreCase("R"))
    {
        System.out.println("Result NO:"+matcher.group(2));
        System.out.println("Component:"+matcher.group(3));
        System.out.println("value:"+matcher.group(4));
        System.out.println("unit:"+matcher.group(5));

        System.out.println("##############################");
    }
    else if(matcher.group(6)!=null && matcher.group(6).equalsIgnoreCase("P"))
    {
        System.out.println("Patient :"+matcher.group(7));
        System.out.println("Patient Number:"+matcher.group(8));

        System.out.println("##############################");
    }
}