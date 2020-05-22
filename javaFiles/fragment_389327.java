String s  = "3/4 length sleeve\n" +
            "3/4 length sleeves\n" +
            "3/4th length sleeve\n" +
            "3/4 sleeve\n" +
            "3/4 sleeves\n"+
            "3/4th sleeve\n" +
            "3/4th sleeves\n" +
            "long sleeves\n" +
            "longfoobarsleeve" +
            "shortnjjgfjghfdjghsleeves\n" +
            "shorts sleeveeees\n" +
            "short sleeve";

Pattern p = Pattern.compile("(3/4|long|short).*?(sleeve)");
Matcher m = p.matcher(s);

while (m.find()) {
  System.out.println(m.group(1) + " " + m.group(2));
}