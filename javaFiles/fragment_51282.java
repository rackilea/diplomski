String myStr = "0123456789012345678901234567890123456789012345678901234567890123456789";

Matcher m = Pattern.compile(".{1,16}").matcher(myStr);
while (m.find()) {
    String s = m.group();
    //do what you want with current token stored in `s`
    System.out.println(s);
}