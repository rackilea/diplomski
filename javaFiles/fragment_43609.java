String str = " Door 51 text1 Door 61 text2 Door 10 text3";
 Pattern pattern = Pattern.compile("\\bDoor\\s+\\d+(.*?)(?=\\bDoor\\s+\\d+|$)");
 Matcher matcher = pattern.matcher(str);
 while (matcher.find()) {
    System.out.println(matcher.group(1));
 }