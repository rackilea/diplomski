public static void regex(){
Pattern pat = Pattern.compile("<FONT [^>]*>(.*?)</FONT>");//
String s = "<html>\n" +
            "<body>\n" +
            "\n" +
            "<P ALIGN=\"LEFT\">\n" +
            "         <FONT FACE=\"Arial\" SIZE=\"1\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">ZUZZU Full Service Provision</FONT>\n" +
            "     </P>\n" +
            "     <P ALIGN=\"LEFT\">\n" +
            "         <FONT FACE=\"Arial\" SIZE=\"1\" COLOR=\"#000000\" LETTERSPACING=\"0\" KERNING=\"0\">&uuml; &ouml; &auml; &Auml; &Uuml; &Ouml; &szlig;</FONT>\n" +
            "     </P>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
Matcher m = pat.matcher(s);
while (m.find()) {
    String found = m.group(1);
    System.out.println("Found : " + found);      
}