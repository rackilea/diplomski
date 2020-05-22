String s  = "Hey,\n" +
            "I just blahblah\n" +
            "E-Mail: lolcat@catinator.com\n" +
            "Another would be lolcat2@catinator.com";

Pattern p = Pattern.compile("\\S+@\\S+");
Matcher m = p.matcher(s);

while (m.find()) {
  System.out.println(m.group());
}